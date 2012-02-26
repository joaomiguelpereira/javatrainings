package eu.jpereira.trainings.jee.persistence.model.items;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;

//TODO: This is the base class for all types of Items sold by a department. This should be persistable because is used in polymorphic operations. Annotate withe the proper annotation

public abstract class SellableItem extends BasicDomainObject {

	protected String name;
	protected String description;
	protected Float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public static abstract class Builder<T extends SellableItem> {
		T instance;

		public Builder() {
			instance = createInstance();
		}

		public Builder<T> withName(String name) {
			this.instance.name = name;
			return this;
		}

		public Builder<T> withDescription(String description) {
			this.instance.description = description;
			return this;
		}

		public Builder<T> withPrice(Float price) {
			this.instance.price = price;
			return this;
		}

		public T build() {
			T newInstance = instance;
			instance = createInstance();
			return newInstance;
		}

		protected abstract T createInstance();
	}

}
