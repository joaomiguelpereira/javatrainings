package eu.jpereira.trainings.jee.persistence.model.cart;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;
import eu.jpereira.trainings.jee.persistence.model.items.SellableItem;

//TODO: The Cart Domain Object should be mapped to a table in the DB with the same name as this class
public class Cart extends BasicDomainObject {

	// TODO: A cart has a unidirectional one to many relationship to
	// SellableItems. Annotate with the proper annotation
	private List<SellableItem> items;

	public void addItem(SellableItem sellableItem) {
		if (this.items == null) {
			this.items = new ArrayList<SellableItem>();
		}
		this.items.add(sellableItem);

	}

	public boolean isEmpty() {
		return this.items != null && this.items.size() > 0 ? false : true;

	}

	public void addItems(List<SellableItem> allItems) {
		this.items = allItems;

	}

	public int itemCount() {

		return this.items != null ? this.items.size() : 0;
	}

	public void empty() {
		this.items.clear();

	}

	public Float calculatePrice() {
		float price = 0;
		for (SellableItem sellableItem : this.items) {
			price += sellableItem.getPrice();
		}
		return price;
	}

}
