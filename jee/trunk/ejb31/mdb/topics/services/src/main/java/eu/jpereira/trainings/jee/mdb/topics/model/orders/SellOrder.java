package eu.jpereira.trainings.jee.mdb.topics.model.orders;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;

import eu.jpereira.trainings.jee.mdb.topics.model.PersistenteDomainObject;
import eu.jpereira.trainings.jee.mdb.topics.model.customers.Customer;
import eu.jpereira.trainings.jee.mdb.topics.model.items.Item;
import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;

@NamedQueries({
		@NamedQuery(name = "findOldestUnprocessedOrder", query = "select o from SellOrder o where o.status='PLACED' order by o.createdAt"),
		@NamedQuery(name = "allProcessingOrders", query = "select o from SellOrder o where o.status='PROCESSING'") })
@Entity
public class SellOrder extends PersistenteDomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany
	private List<Item> items;

	@ManyToOne
	private Customer customer;

	private Long createdAt;

	@Enumerated(EnumType.STRING)
	private SellOrderStatus status;

	public SellOrderStatus moveNextState() {
		this.status = this.status.nextState();
		return this.status;
	}

	public SellOrderStatus getStatus() {
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

	public Integer getTotalPrice() {
		Integer price = 0;
		if (this.items != null) {
			for (Item item : this.items) {
				price += item.getPrice();
			}
		}
		return price;
	}

	@SuppressWarnings("unused")
	@PrePersist
	private void prepareOrderToPersist() {

		this.createdAt = System.currentTimeMillis();
		this.status = SellOrderStatus.PLACED;
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

	public String getType() {
		// Move this logic into the enum
		if (this.getTotalPrice() >= 90) {
			return SellOrderType.BIG.name();
		} else if (this.getTotalPrice() <= 30) {
			return SellOrderType.SMALL.name();
		} else {
			return SellOrderType.AVERAGE.name();
		}

	}

}
