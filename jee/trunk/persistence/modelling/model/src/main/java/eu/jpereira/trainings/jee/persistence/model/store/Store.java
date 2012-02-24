package eu.jpereira.trainings.jee.persistence.model.store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;
import eu.jpereira.trainings.jee.persistence.model.customer.Customer;
import eu.jpereira.trainings.jee.persistence.model.store.Store.Builder;

/**
 * Store domain object
 * 
 * @author jee
 * 
 */
@Entity
public class Store extends BasicDomainObject {

	private String name;

	private String description;

	@OneToMany(mappedBy = "store")
	private List<Department> departments;

	@OneToMany(mappedBy = "store")
	private List<Customer> customers;

	@Embedded
	public PostalAddress postalAddress;

	public String getName() {
		return name;
	}

	public void addDepartment(Department department) {

		if (this.departments == null) {
			this.departments = new ArrayList<Department>();
		}

		department.assignToStore(this);

		this.departments.add(department);

	}

	/**
	 * Builder class for {@link Store} instances;
	 * 
	 * @author jee
	 * 
	 */
	public static class Builder {
		private Store object;

		public Builder() {
			this.object = new Store();
		}

		public Builder withName(String name) {
			this.object.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.object.description = description;
			return this;
		}

		public Store build() {
			// Copy reference
			Store builtStore = this.object;
			// Initialize object
			this.object = new Store();

			return builtStore;
		}

		public Builder withPostalAddress(PostalAddress address) {
			this.object.postalAddress = address;
			return this;
		}
	}

	public List<Department> getAllDepartments() {
		return this.departments;
	}

	public void addCustomer(Customer customer) {
		if (this.customers == null) {
			this.customers = new ArrayList<Customer>();
		}
		customer.assignToStore(this);
		this.customers.add(customer);

	}

	public List<Customer> getAllCustomers() {
		return this.customers;
	}

	public void removeCustomer(Customer customer) {
		customer.assignToStore(null);
		this.customers.remove(customer);

	}

	public void removeDepartment(Department department) {
		department.assignToStore(null);
		this.departments.remove(department);

	}
}
