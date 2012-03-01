package eu.jpereira.trainings.jee.mdb.queues.service.items;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.queues.model.items.Item;
import eu.jpereira.trainings.jee.mdb.queues.model.items.Items;

@Stateless
@Remote(ItemsRemoteFacade.class)
public class ItemsService implements ItemsRemoteFacade{

	
	private  @EJB Items itemsDAO;
	
	@Override
	public Item createItem(Item item) {
		Long itemId = itemsDAO.persist(item);
		return itemsDAO.findById(itemId);
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
