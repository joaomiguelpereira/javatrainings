package eu.jpereira.trainings.jee.mdb.topics.model.orders;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.topics.model.PersistenteDomainObjectDAO;

public interface SellOrders extends PersistenteDomainObjectDAO<SellOrder>{

	/**
	 * Return the oldest placed order
	 * 
	 * @return
	 */
	SellOrder findOldestUnprocessedOrder();

	List<SellOrder> findAllProcessing();

	

}
