package eu.jpereira.trainings.jee.mdb.queues.model.items;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.queues.model.BasicDAO;

@Stateless
@Local(Items.class)
public class DefaultItemsDAO extends BasicDAO<Item> implements Items {

	@Override
	public List<Item> newItems(List<Item> items) {
		
		for (Item item : items) {
			persist(item);
		}
		return items;
	}

}
