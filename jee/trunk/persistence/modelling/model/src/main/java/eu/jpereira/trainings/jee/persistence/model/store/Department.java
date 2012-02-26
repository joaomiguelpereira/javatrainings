package eu.jpereira.trainings.jee.persistence.model.store;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;
import eu.jpereira.trainings.jee.persistence.model.items.SellableItem;

/**
 * Domain object representing a Department
 * 
 * @author jee
 * 
 */
//TODO: This should be mapped to a table in the DB named after the class name
public class Department extends BasicDomainObject {

	private String name;

	// TODO: A department has a reference to the store that has this department.
	// This field is part of a bidirectional OneToMany relationship in the
	// Store Object. Annotate this field to be mapped as the other end of a
	// OneToMany relationship bidirectional relationship.
	private Store store;

	// TODO: A Department has many items that can sell. This is a unidirectional
	// one to many relationship. Annotate with the proper annotation to map this
	// collection to a one to many relationship. Also, let the persistence
	// provider to cascade all operations in child objects
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

	public Store getStore() {

		return this.store;
	}

}
