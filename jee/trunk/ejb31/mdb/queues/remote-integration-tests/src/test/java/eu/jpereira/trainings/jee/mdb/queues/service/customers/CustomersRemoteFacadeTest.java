package eu.jpereira.trainings.jee.mdb.queues.service.customers;

import javax.naming.NamingException;

import org.junit.Test;

import eu.jpereira.trainings.jee.mdb.queues.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.queues.test.RemoteStatelessBeanTest;

import static org.junit.Assert.*;

public class CustomersRemoteFacadeTest extends
		RemoteStatelessBeanTest<CustomersRemoteFacade, CustomersService> {

	@Test
	public void testCreateCustomer() throws NamingException {

		CustomersRemoteFacade facade = beanInstance();
		
		int customerCount = facade.getCostumers().size();
		
		facade.createCustomer(new Customer.Builder().withName("Jon Doe").build());
		
		assertEquals(customerCount+1, facade.getCostumers().size());

	}
	

}
