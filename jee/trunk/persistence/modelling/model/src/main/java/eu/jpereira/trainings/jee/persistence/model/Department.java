package eu.jpereira.trainings.jee.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import eu.jpereira.trainings.jee.persistence.model.items.SellableItem;

@Entity
public class Department extends BasicDomainObject {

	private String name;

	@ManyToOne
	private Store store;

	@OneToMany(cascade=CascadeType.ALL)
	private List<SellableItem> sellableItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class Builder {
		private Department object;

		public Builder() {
			this.object = new Department();
		}

		public Builder withName(String name) {
			this.object.name = name;
			return this;
		}

		public Department build() {
			// Copy reference
			Department newDepartment = this.object;
			this.object = new Department();
			return newDepartment;

		}
	}

	public void assignToStore(Store ownerStore) {
		this.store = ownerStore;

	}

	public void addSellableItem(SellableItem sellableItem) {
		if (this.sellableItems == null) {
			this.sellableItems = new ArrayList<SellableItem>();
		}

		this.sellableItems.add(sellableItem);

	}

	public List<SellableItem> getAllSellableItems() {
		return this.sellableItems;
	}

	public void removeSellableItem(SellableItem itemToRemove) {

		this.sellableItems.remove(itemToRemove);
	}

}
