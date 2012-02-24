package eu.jpereira.trainings.jee.persistence.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.impl.SessionImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;

/**
 * 
 * @author joaomiguel.pereira@gmail.com
 * 
 */
@Ignore
public abstract class DomainObjectTest<T> extends PersistenceTest{

	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	// The name of the persistence context configured in
	// src/test/resources/META-INF/persistence.xml
	private static String persistenceUnitName = "testPU";

	/**
	 * Will create a new EntityManager for the persistence unit
	 */
	@BeforeClass
	public static void initiTestCase() {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
	}

	/**
	 * This will clear all tables from HSQLDB
	 * @throws SQLException
	 */
	private void clearDatabase() throws SQLException {
	    Connection c = ((SessionImpl) em.getDelegate()).connection();
	    Statement s = c.createStatement();
	    s.execute("SET DATABASE REFERENTIAL INTEGRITY FALSE");
	    Set<String> tables = new HashSet<String>();
	    ResultSet rs = s.executeQuery("select table_name " +
	        "from INFORMATION_SCHEMA.system_tables " +
	        "where table_type='TABLE' and table_schem='PUBLIC'");
	    while (rs.next()) {
	        if (!rs.getString(1).startsWith("DUAL_")) {
	            tables.add(rs.getString(1));
	        }
	    }
	    rs.close();
	    for (String table : tables) {
	        s.executeUpdate("DELETE FROM " + table);
	    }
	    s.execute("SET DATABASE REFERENTIAL INTEGRITY TRUE");
	    s.close();
	    beginTx();
	    em.flush();
	    commitTx();
	}
	@Before
	public void reset() throws SQLException {
		clearDatabase();

	}

	/**
	 * Open a transaction
	 */
	@Ignore
	protected void beginTx() {
		em.getTransaction().begin();
	}

	/**
	 * Commit a transaction
	 */
	@Ignore
	protected void commitTx() {
		em.getTransaction().commit();
	}

	/**
	 * Shutdow entitymanager and entitymanager factory
	 */
	@AfterClass
	public static void shutDown() {
		if (em != null)
			em.close();

		if (emf != null)
			emf.close();

	}

	/**
	 * Asserts that exists the expected number of entities in the DB
	 * 
	 * @param expected
	 * @param clazz
	 */
	protected void assertEntitySize(int expected) {
		assertEquals(expected, getEntityCount());
	}

	/**
	 * Get the number of persisted object of class clazz in the persistence
	 * context
	 * 
	 * @param clazz
	 * @return
	 */
	protected int getEntityCount() {
		Class<T> type = getType();
		String q = "select x from " + type.getSimpleName() + " x";
		return em.createQuery(q, type).getResultList().size();

	}

	/**
	 * Detacth an entity
	 * 
	 * @param object
	 */
	protected void detach(Object object) {
		assertTrue(em.contains(object));
		em.detach(object);
		assertFalse(em.contains(object));

	}

	@SuppressWarnings("unchecked")
	private Class<T> getType() {

		ParameterizedType pType = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] types = pType.getActualTypeArguments();
		Class<T> type = (Class<T>) types[0];
		return type;
	}

	protected List<T> gettAll() {

		Class<T> type = getType();

		StringBuilder jpqlQueryBuilder = new StringBuilder();
		jpqlQueryBuilder.append("select o from ");
		jpqlQueryBuilder.append(type.getSimpleName()).append(" o");
		return em.createQuery(jpqlQueryBuilder.toString(), type)
				.getResultList();
	}

	protected void persistDummyObjects(int max) throws BuilderRequiredValue {
		if (!em.getTransaction().isActive())
			throw new IllegalArgumentException(
					"Must have an active transaction. Call beginTx() before invoking this method");
		for (int i = 0; i < max; i++) {

			T object = createDummyObjectWithSerialNumber(i);
			em.persist(object);
		}

	}

	protected T find(Object primaryKey) {
		return em.find(getType(), primaryKey);
	}

	protected abstract T createDummyObjectWithSerialNumber(int i) throws BuilderRequiredValue;
}
