package eu.jpereira.trainings.jee.mdb.topics.model.customers;

import javax.ejb.Local;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.topics.model.BasicDAO;

@Stateless
@Local(Customers.class)
public class DefaultCustomersDAO extends BasicDAO<Customer> implements Customers {

	
	

}
