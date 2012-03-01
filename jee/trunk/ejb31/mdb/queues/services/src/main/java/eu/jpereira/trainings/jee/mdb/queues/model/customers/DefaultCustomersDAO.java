package eu.jpereira.trainings.jee.mdb.queues.model.customers;

import javax.ejb.Local;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.queues.model.BasicDAO;

@Stateless
@Local(Customers.class)
public class DefaultCustomersDAO extends BasicDAO<Customer> implements Customers {

	
	

}
