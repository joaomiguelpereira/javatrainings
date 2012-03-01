package eu.jpereira.trainings.jee.mdb.queues.service.orders;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.jpereira.trainings.jee.mdb.queues.model.ModelNotFoundException;
import eu.jpereira.trainings.jee.mdb.queues.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.queues.model.items.Item;
import eu.jpereira.trainings.jee.mdb.queues.service.customers.CustomersRemoteFacade;
import eu.jpereira.trainings.jee.mdb.queues.service.customers.CustomersService;
import eu.jpereira.trainings.jee.mdb.queues.service.items.ItemsRemoteFacade;
import eu.jpereira.trainings.jee.mdb.queues.service.items.ItemsService;
import eu.jpereira.trainings.jee.mdb.queues.test.RemoteStatelessBeanTest;

public class OrdersRemoteFacadeTest extends
		RemoteStatelessBeanTest<OrdersRemoteFacade, OrdersService> {

	private static Customer testCustomer;
	private static List<Item> testItems;

	@BeforeClass
	public static void setUpFixtures() throws NamingException {
		// Get a way to clean the db. Now the project is using jboss default db,
		// but you can change to use other you can better control, or control
		// the one in jboss
		// get the required facades
		CustomersRemoteFacade customerFacade = getStatelessSessionBeanReferenceFor(
				CustomersRemoteFacade.class, CustomersService.class);
		ItemsRemoteFacade itemsFacade = getStatelessSessionBeanReferenceFor(
				ItemsRemoteFacade.class, ItemsService.class);

		// create a customer
		Long customerId = customerFacade.createCustomer(new Customer.Builder()
				.withName("Create order test Customer").build());

		testCustomer = customerFacade.getCustomer(customerId);

		System.out.println("Test customer id: " + testCustomer.getId());

		// Create 10 items
		List<Item> items = new ArrayList<Item>(10);
		for (int i = 0; i < 10; i++) {
			items.add(new Item.Builder().withName("Item " + i)
					.withDescription("description").withPrice(10f + i).build());
		}
		testItems = itemsFacade.createItems(items);

	}

	@Test(timeout = 600000)
	public void testCreateOrder() throws NamingException,
			ModelNotFoundException, InterruptedException {

		OrdersRemoteFacade facade = beanInstance();
		List<Long> itemsId = getTestItemsIds();
		Long customerId = testCustomer.getId();
		// Count the number of orders befor test (next iteration in the test
		// framework is to clear the db of jboss in each test)
		int orderCount = facade.getOrdersCount();
		facade.placeOrder(itemsId, customerId);

		int currentOrdersCount = facade.getOrdersCount();
		assertEquals(orderCount + 1, currentOrdersCount);

		// now, just wait it to be processed

		int processedOrder = 0;
		while (processedOrder < currentOrdersCount) {

			processedOrder = facade.getProcessingOrdersCount();
			System.out.println("processed orders: "+processedOrder);
			Thread.sleep(5000);

		}

	}

	private List<Long> getTestItemsIds() {
		List<Long> ids = new ArrayList<Long>();

		for (Item item : testItems) {
			ids.add(item.getId());
		}
		return ids;
	}
}
