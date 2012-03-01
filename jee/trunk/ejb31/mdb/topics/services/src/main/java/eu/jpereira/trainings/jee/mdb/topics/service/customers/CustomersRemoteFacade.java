package eu.jpereira.trainings.jee.mdb.topics.service.customers;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customer;

public interface CustomersRemoteFacade {

	Long createCustomer(Customer customer);

	List<Customer> getCostumers();

	Customer getCustomer(Long customerId);
}
