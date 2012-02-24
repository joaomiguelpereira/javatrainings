package eu.jpereira.trainings.jee.persistence.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Ignore;

import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;

/**
 * 
 * @author joaomiguel.pereira@gmail.com
 * 
 */
@Ignore
public abstract class DomainObjectTest<T> extends PersistenceTest {
	
	
	

	
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
