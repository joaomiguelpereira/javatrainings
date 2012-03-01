package eu.jpereira.trainings.jee.mdb.queues.service.customers;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.queues.model.customers.Customer;

public interface CustomersRemoteFacade {

	Long createCustomer(Customer customer);

	List<Customer> getCostumers();

	Customer getCustomer(Long customerId);
}
