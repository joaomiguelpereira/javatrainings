package eu.jpereira.trainings.jee.mdb.topics.service.items;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.topics.model.items.Item;

public interface ItemsRemoteFacade {

	Item createItem(Item item);
	List<Item> createItems(List<Item> items);
	List<Item> getItems();
	
}
