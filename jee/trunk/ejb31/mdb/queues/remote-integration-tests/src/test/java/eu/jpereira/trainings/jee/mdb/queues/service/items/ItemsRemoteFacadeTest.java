package eu.jpereira.trainings.jee.mdb.queues.service.items;

import javax.naming.NamingException;

import org.junit.Test;

import eu.jpereira.trainings.jee.mdb.queues.model.items.Item;
import eu.jpereira.trainings.jee.mdb.queues.test.RemoteStatelessBeanTest;

import static org.junit.Assert.*;

public class ItemsRemoteFacadeTest extends
		RemoteStatelessBeanTest<ItemsRemoteFacade, ItemsService> {

	@Test
	public void testCreateItem() throws NamingException {

		ItemsRemoteFacade facade = beanInstance();

		int itemCount = facade.getItems().size();

		facade.createItem(new Item.Builder().withName("Item Name")
				.withDescription("Item description").withPrice(190.0f).build());

		assertEquals(itemCount + 1, facade.getItems().size());
	}
}
