package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.topics.model.ModelNotFoundException;
import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;

public interface OrdersRemoteFacade {

	Long placeOrder(List<Long> itemsIds, Long customerID) throws ModelNotFoundException;

	Integer getOrdersCount();

	Integer getProcessingOrdersCount();
	
	Integer getProcessedOrders(SellOrderType type);
}
