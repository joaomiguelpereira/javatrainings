package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.topics.model.ModelNotFoundException;
import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customers;
import eu.jpereira.trainings.jee.mdb.topics.model.items.Item;
import eu.jpereira.trainings.jee.mdb.topics.model.items.Items;
import eu.jpereira.trainings.jee.mdb.topics.model.orders.SellOrder;
import eu.jpereira.trainings.jee.mdb.topics.model.orders.SellOrders;
import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;

@Stateless
@Remote(OrdersRemoteFacade.class)
public class OrdersService implements OrdersRemoteFacade {

	private @EJB
	SellOrders orders;
	private @EJB
	Customers customers;
	private @EJB
	Items items;

	
	private @EJB SellOrderCounter ordersCounter;

	//TODO: Inject an EJB of type SellOrderNotifier
	
	//private SellOrderNotfier notifier;

	@Override
	public Long placeOrder(List<Long> itemsIds, Long customerID)
			throws ModelNotFoundException {

		// TODO: Validations
		if (customerID == null) {
			throw new ModelNotFoundException();
		}
		Customer customer = customers.findById(customerID);
		List<Item> itemsList = items.findAllByIds(itemsIds);

		SellOrder order = orders.persist(new SellOrder.Builder()
				.forCustomer(customer).withItems(itemsList).build());

		// This is a good integration for sending a message to the topic
		//TODO: Use the SellOrderNotigier EJB to send a message
		/*
		try {
			notifier.notifyNewSellOrder(order);
		} catch (JMSException e) {
			// Just log it
			e.printStackTrace();
		}
        */
		return order.getId();

	}

	@Override
	public Integer getOrdersCount() {

		return orders.all().size();

	}

	@Override
	public Integer getProcessingOrdersCount() {

		return orders.findAllProcessing().size();
	}

	@Override
	public Integer getProcessedOrders(SellOrderType type) {
		return ordersCounter.getCountFor(type);
	}

}
