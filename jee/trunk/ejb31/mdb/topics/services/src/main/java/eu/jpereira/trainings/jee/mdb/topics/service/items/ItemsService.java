package eu.jpereira.trainings.jee.mdb.topics.service.items;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.topics.model.items.Item;
import eu.jpereira.trainings.jee.mdb.topics.model.items.Items;

@Stateless
@Remote(ItemsRemoteFacade.class)
public class ItemsService implements ItemsRemoteFacade{

	
	private  @EJB Items itemsDAO;
	
	@Override
	public Item createItem(Item item) {
		return itemsDAO.persist(item);
	}

	@Override
	public List<Item> createItems(List<Item> items) {
		
		return itemsDAO.newItems(items);
	}

	@Override
	public List<Item> getItems() {
		return itemsDAO.all();
	}
	

}
