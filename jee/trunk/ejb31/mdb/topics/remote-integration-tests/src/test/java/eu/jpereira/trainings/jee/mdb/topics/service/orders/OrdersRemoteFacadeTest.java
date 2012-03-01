package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.jpereira.trainings.jee.mdb.topics.model.ModelNotFoundException;
import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.topics.model.items.Item;
import eu.jpereira.trainings.jee.mdb.topics.service.customers.CustomersRemoteFacade;
import eu.jpereira.trainings.jee.mdb.topics.service.customers.CustomersService;
import eu.jpereira.trainings.jee.mdb.topics.service.items.ItemsRemoteFacade;
import eu.jpereira.trainings.jee.mdb.topics.service.items.ItemsService;
import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;
import eu.jpereira.trainings.jee.mdb.topics.test.RemoteStatelessBeanTest;

public class OrdersRemoteFacadeTest extends
		RemoteStatelessBeanTest<OrdersRemoteFacade, OrdersService> {

	private static List<Customer> testCustomers;
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

		// create 10 customers
		testCustomers = new ArrayList<Customer>(10);
		for (int i = 0; i < 10; i++) {

			Long customerId = customerFacade
					.createCustomer(new Customer.Builder().withName(
							"Create order test Customer").build());

			testCustomers.add(customerFacade.getCustomer(customerId));

		}

		// Create 10 items
		List<Item> items = new ArrayList<Item>(100);
		for (int i = 0; i < 10; i++) {
			items.add(new Item.Builder().withName("Item " + i)
					.withDescription("description").withPrice((i + 1) * 10)
					.build());
		}
		testItems = itemsFacade.createItems(items);

	}

	@Test(timeout = 600000)
	public void testCreateOrder() throws NamingException,
			ModelNotFoundException, InterruptedException {

		OrdersRemoteFacade facade = beanInstance();

		facade.placeOrder(getTestItemsIds(), getCustomer().getId());
		facade.placeOrder(getTestItemsIds(), getCustomer().getId());
		facade.placeOrder(getTestItemsIds(), getCustomer().getId());

		boolean done = false;
		while (!done) {
			done = true;
			for (SellOrderType type : SellOrderType.values()) {
				int count = facade.getProcessedOrders(type);
				
				done = done &  count > 0;
			}
			System.out.println("Sleeping...");
			Thread.sleep(5000);

		}

	}

	private Customer getCustomer() {
		// TODO Auto-generated method stub
		Customer customer = testCustomers.get(0);
		testCustomers.remove(0);
		return customer;
	}

	private List<Long> getTestItemsIds() {

		List<Long> ids = new ArrayList<Long>();
		ids.add(testItems.get(0).getId());
		ids.add(testItems.get(1).getId());

		testItems.remove(0);
		testItems.remove(1);
		return ids;
	}
}
