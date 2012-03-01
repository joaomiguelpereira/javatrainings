package eu.jpereira.trainings.jee.mdb.topics.service.customers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customers;

@Stateless
@Remote(CustomersRemoteFacade.class)
public class CustomersService implements CustomersRemoteFacade {

	private @EJB
	Customers customersDAO;

	@Override
	public Long createCustomer(Customer customer) {
		return customersDAO.persist(customer).getId();

	}

	@Override
	public List<Customer> getCostumers() {
		return customersDAO.all();
	}

	@Override
	public Customer getCustomer(Long customerId) {
		return customersDAO.findById(customerId);
	}

}
