package eu.jpereira.trainings.jee.persistence.model.customer;

import javax.persistence.PrePersist;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;
import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;
import eu.jpereira.trainings.jee.persistence.model.cart.Cart;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;
import eu.jpereira.trainings.jee.persistence.model.store.Store;

/**
 * Base class for all types of customers
 * 
 * @author jee
 * 
 */
// TODO: This is the base class for all types of customers. This should be it
// self a an entity because is used in polymorphic operations and should be
// mapped to the DB. Annotate with the proper annotation
public abstract class Customer extends BasicDomainObject {

	protected String firstName;

	protected String lastName;

	// TODO: The postal address should be mapped to the same table as customer.
	// Annotate the field with the proper annotation to embedded the object
	// postalAddress to the same table
	protected PostalAddress postalAddress;

	// A customer is the other end of a bidirectional relationship in Store
	// object. Annotate this field to be mapped as the other end of the
	// OneToMany
	// relationship between Store and Customer in Store.
	protected Store store;

	// TODO: Every customer has only one cart. Persistence operations on a
	// Customer shoulp propagate to the Cart object
	protected Cart cart;

	public void assignToStore(Store store) {
		this.store = store;

	}

	public Cart getCart() {

		return this.cart;
	}

	/**
	 * Before persisting a new Customer in the DB this method will be called
	 */
	@SuppressWarnings("unused")
	@PrePersist
	private void setupCustomerCart() {
		this.cart = new Cart();
	}

	public static abstract class CustomerBuilder<T extends Customer> {

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

		public T build() throws BuilderRequiredValue {
			// Will delegate to concrete classes the validation of the object
			validateObject();

			T newInstance = instance;

			instance = createInstance();
			return newInstance;
		}

		protected abstract void validateObject() throws BuilderRequiredValue;

	}
}
