package eu.jpereira.trainings.jee.mdb.queues.model.orders;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import eu.jpereira.trainings.jee.mdb.queues.model.BasicDAO;

@Stateless
@Local(Orders.class)
public class DefaultOrdersDAO extends BasicDAO<SellOrder> implements Orders {

	@Override
	public SellOrder findOldestUnprocessedOrder() {
		System.out.println("Finding order...");

		TypedQuery<SellOrder> query = em.createNamedQuery(
				"findOldestUnprocessedOrder", SellOrder.class);

		
		SellOrder order = null;
		try {
			query.setMaxResults(1);
			order = query.getSingleResult();

			System.out.println("Order: " + order);

		} catch (NoResultException e) {
			//it's ok!
		}
		return order;
	}

	@Override
	public List<SellOrder> findAllProcessing() {
		TypedQuery<SellOrder> query = em.createNamedQuery("allProcessingOrders", SellOrder.class);
		return query.getResultList();
	}

}
