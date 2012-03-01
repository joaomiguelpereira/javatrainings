package eu.jpereira.trainings.jee.mdb.topics.model.items;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.topics.model.PersistenteDomainObjectDAO;

public interface Items extends PersistenteDomainObjectDAO<Item>{

	

	List<Item> newItems(List<Item> items);


}
