package eu.jpereira.trainings.jee.mdb.topics.model;

import java.util.List;

public interface PersistenteDomainObjectDAO<T extends PersistenteDomainObject>{

	T findById(Long id);
	
	List<T> findAllByIds(List<Long> itemsIds);
	
	List<T> all();
	
	T persist(T modelObject);
	



}
