package eu.jpereira.trainings.jee.mdb.topics.model.items;

import java.io.Serializable;

import javax.persistence.Entity;

import eu.jpereira.trainings.jee.mdb.topics.model.PersistenteDomainObject;

@Entity
public class Item extends PersistenteDomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private Integer price;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getPrice() {
		return price;
	}

	
	public static class Builder extends PersistenteDomainObject.Builder<Item> {

		@Override
		protected Item createInstance() {
			return new Item();
		}
		
		public Builder withName(String name) {
			this.instance.name = name;
			return this;
		}
		public Builder withDescription(String description) {
			this.instance.description = description;
			return this;
		}
		
		public Builder withPrice(Integer price) {
			this.instance.price = price;
			return this;
		}
		
	}
}
