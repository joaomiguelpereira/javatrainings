package eu.jpereira.trainings.jee.mdb.topics.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eu.jpereira.trainings.jee.mdb.topics.model.items.Item;

public abstract class BasicDAO<T extends PersistenteDomainObject> implements
		PersistenteDomainObjectDAO<T> {

	@PersistenceContext(name = "orders")
	protected EntityManager em;

	public T persist(T newInstance) {
		em.persist(newInstance);
		return newInstance;
	}

	@Override
	public T findById(Long id) {
		return em.find(getType(), id);
	}

	@Override
	public List<T> findAllByIds(List<Long> itemsIds) {
		// now just return all in the DB. Exercise: use Criteria
		// For the exercise, I'm not bothering constructing the query
		List<T> list = new ArrayList<T>();
		
		for (T object : all()) {
			for (Long id : itemsIds) {
				if (id.equals(object.getId())) {
					list.add(object);
				}
			}
		}
		return list;
	}

	@Override
	public List<T> all() {
		// Use criteria instead
		Class<T> type = getType();
		StringBuilder query = new StringBuilder().append("select t from ")
				.append(type.getSimpleName()).append(" t");
		return em.createQuery(query.toString(), type).getResultList();
	}

	private Class<T> getType() {
		ParameterizedType pType = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] types = pType.getActualTypeArguments();
		return (Class<T>) types[0];

	}

}
