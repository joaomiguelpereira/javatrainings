package eu.jpereira.trainings.jee.mdb.queues.model.customers;

import java.io.Serializable;

import javax.persistence.Entity;

import eu.jpereira.trainings.jee.mdb.queues.model.PersistenteDomainObject;

@Entity
public class Customer extends PersistenteDomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2375938047143706588L;
	private String name;

	public String getName() {
		return name;
	}

	public static class Builder extends
			PersistenteDomainObject.Builder<Customer> {

		public Builder withName(String name) {
			this.instance.name = name;
			return this;
		}

		@Override
		protected Customer createInstance() {
			return new Customer();
		}

	}

}
