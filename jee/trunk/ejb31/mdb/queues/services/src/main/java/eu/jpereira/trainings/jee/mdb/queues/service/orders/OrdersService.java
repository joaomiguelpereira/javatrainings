package eu.jpereira.trainings.jee.mdb.queues.service.orders;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.queues.model.ModelNotFoundException;
import eu.jpereira.trainings.jee.mdb.queues.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.queues.model.customers.Customers;
import eu.jpereira.trainings.jee.mdb.queues.model.items.Item;
import eu.jpereira.trainings.jee.mdb.queues.model.items.Items;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.Orders;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.SellOrder;

@Stateless
@Remote(OrdersRemoteFacade.class)
public class OrdersService implements OrdersRemoteFacade {

	private @EJB
	Orders orders;
	private @EJB
	Customers customers;
	private @EJB
	Items items;

	@Override
	public Long placeOrder(List<Long> itemsIds, Long customerID) throws ModelNotFoundException{

		// TODO: Validations
		if ( customerID == null ) {
			throw new ModelNotFoundException();
		}
		Customer customer = customers.findById(customerID);
		List<Item> itemsList = items.findAllByIds(itemsIds);

		return orders.persist(new SellOrder.Builder().forCustomer(customer)
				.withItems(itemsList).build());
		
		

	}

	@Override
	public Integer getOrdersCount() {

		return orders.all().size();

	}

	@Override
	public Integer getProcessingOrdersCount() {
		
		return orders.findAllProcessing().size();
	}

}
