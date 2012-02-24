package eu.jpereira.trainings.jee.persistence.model.customer;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;
import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;
import eu.jpereira.trainings.jee.persistence.model.cart.Cart;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;
import eu.jpereira.trainings.jee.persistence.model.store.Store;

@Entity
public abstract class Customer extends BasicDomainObject {

	protected String firstName;

	protected String lastName;

	@Embedded
	protected PostalAddress postalAddress;

	@ManyToOne
	protected Store store;

	@OneToOne(cascade = CascadeType.ALL)
	protected Cart cart;

	public void assignToStore(Store store) {
		this.store = store;

	}

	public Cart getCart() {

		return this.cart;
	}

	@SuppressWarnings("unused")
	@PrePersist
	private void setupCustomerCart() {
		this.cart = new Cart();
	}

	public static abstract class CustomerBuilder<T extends Customer>  {

		protected T instance;

		/**
		 * Delegate to concrete classes the instantiation of correct methods.
		 * 
		 * @return
		 */
		protected abstract T createInstance();

		public CustomerBuilder() {
			instance = createInstance();
		}

		public CustomerBuilder<T> withFirstName(String firstName) {
			this.instance.firstName = firstName;
			return this;
		}

		public CustomerBuilder<T> withLastName(String lasteName) {
			this.instance.lastName = lasteName;
			return this;
		}

		public CustomerBuilder<T> withPostalAddress(PostalAddress address) {
			this.instance.postalAddress = address;
			return this;
		}

		public T build()throws BuilderRequiredValue {
			//Will delegate to concrete classes the validation of the object
			validateObject();
			
			T newInstance = instance;

			instance = createInstance();
			return newInstance;
		}

		protected  abstract void validateObject() throws BuilderRequiredValue;

		
	}
}
