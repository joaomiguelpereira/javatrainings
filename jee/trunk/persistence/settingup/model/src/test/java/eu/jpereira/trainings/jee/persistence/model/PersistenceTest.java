package eu.jpereira.trainings.jee.persistence.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.junit.Assert.*;

/**
 * 
 * @author joaomiguel.pereira@gmail.com
 * 
 */
@Ignore
public abstract class PersistenceTest {

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
	protected void assertEntitySize(int expected, Class<?> clazz) {
		assertEquals(expected, getEntityCount(clazz));
	}
	

	/**
	 * Get the number of persisted object of class clazz in the persistence context
	 * @param clazz
	 * @return
	 */
	protected int getEntityCount(Class<?> clazz) {
		String q = "select x from " + clazz.getSimpleName() + " x";
		return em.createQuery(q, clazz).getResultList().size();

	}

	/**
	 * Detacth an entity
	 * @param object
	 */
	protected void detach(Object object) {
		assertTrue(em.contains(object));
		em.detach(object);
		assertFalse(em.contains(object));

	}
}
