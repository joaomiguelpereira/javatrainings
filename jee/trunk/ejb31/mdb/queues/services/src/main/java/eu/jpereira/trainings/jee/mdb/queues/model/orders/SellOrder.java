package eu.jpereira.trainings.jee.mdb.queues.model.orders;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import eu.jpereira.trainings.jee.mdb.queues.model.PersistenteDomainObject;
import eu.jpereira.trainings.jee.mdb.queues.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.queues.model.items.Item;

@NamedQueries({
		@NamedQuery(name = "findOldestUnprocessedOrder", query = "select o from SellOrder o where o.status='PLACED' order by o.createdAt"),
		@NamedQuery(name = "allProcessingOrders", query = "select o from SellOrder o where o.status='PROCESSING'") })
@Entity
public class SellOrder extends PersistenteDomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany
	private List<Item> items;

	@ManyToOne
	private Customer customer;

	private Long createdAt;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public OrderStatus moveNextState() {
		this.status = this.status.nextState();
		return this.status;
	}

	public OrderStatus getStatus() {
		return this.status;
	}

	public List<Item> getItems() {
		return items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	@SuppressWarnings("unused")
	@PrePersist
	private void prepareOrderToPersist() {
		this.createdAt = System.currentTimeMillis();
		this.status = OrderStatus.PLACED;
	}

	public static class Builder extends
			PersistenteDomainObject.Builder<SellOrder> {

		@Override
		protected SellOrder createInstance() {
			return new SellOrder();
		}

		public Builder forCustomer(Customer customer) {
			this.instance.customer = customer;
			return this;
		}

		public Builder withItems(List<Item> items) {
			this.instance.items = items;
			return this;
		}

	}

}
