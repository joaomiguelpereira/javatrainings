package eu.jpereira.trainings.jee.mdb.queues.model.orders;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.queues.model.PersistenteDomainObjectDAO;

public interface Orders extends PersistenteDomainObjectDAO<SellOrder>{

	/**
	 * Return the oldest placed order
	 * 
	 * @return
	 */
	SellOrder findOldestUnprocessedOrder();

	List<SellOrder> findAllProcessing();

	

}
