package eu.jpereira.trainings.jee.mdb.queues.service.orders;

import java.util.List;

import eu.jpereira.trainings.jee.mdb.queues.model.ModelNotFoundException;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.SellOrder;

public interface OrdersRemoteFacade {

	Long placeOrder(List<Long> itemsIds, Long customerID) throws ModelNotFoundException;

	Integer getOrdersCount();

	Integer getProcessingOrdersCount();
}
