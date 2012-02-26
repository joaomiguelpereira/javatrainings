package eu.jpereira.trainings.jee.persistence.model.store;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.jee.persistence.model.BasicDomainObject;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;
import eu.jpereira.trainings.jee.persistence.model.customer.Customer;

/**
 * Store domain object
 * 
 * @author jee
 * 
 */

// TODO: This should be mapped to a table in the DB named after the class name
public class Store extends BasicDomainObject {

	private String name;

	private String description;

	// TODO: One Store has many departments. This relationship is bidirectional,
	// so at the other end of the relationship should exist a reference to this
	// object
	// Annotate the field with the proper annotation
	private List<Department> departments;

	// TODO: One Store has many departments. This relationship is biderectional,
	// so at the other end of the relationship should exes a reference to this
	// object. Annotate the field with proper annotation
	private List<Customer> customers;

	// TODO: PostalAddress should be mapped to the same table as Store, meaning
	// that the object postalAddress should be embedded here. Annotate with the
	// proper annotation to make postalAddress a embedded object of this object
	public PostalAddress postalAddress;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * Add a department to this store.
	 * 
	 * @param department
	 */
	public void addDepartment(Department department) {

		if (this.departments == null) {
			this.departments = new ArrayList<Department>();
		}

		// TODO: Since this is a bidirectional OneToMany relationship, you
		// should set a reference to this object at the other end of the
		// relationship. Uncomment the code bellow
		//department.assignToStore(this);

		this.departments.add(department);

	}

	/**
	 * Add a customer to the store
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		if (this.customers == null) {
			this.customers = new ArrayList<Customer>();
		}
		// TODO: Since this is a biderectional OneToMany relationship, you
		// should set a reference to this object at the other end of the
		// relationship. Uncomment the followinf code
		//customer.assignToStore(this);
		this.customers.add(customer);

	}

	/**
	 * Remove a customer from this store
	 * 
	 * @param customer
	 */
	public void removeCustomer(Customer customer) {
		// TODO: Since this is a bidirectional OneToMany relationship, you
		// should remove the reference to this object from the other end of the
		// relationship. Uncomment the folllowing line
		//customer.assignToStore(null);

		this.customers.remove(customer);

	}

	/**
	 * Remove a department from this store.
	 * 
	 * @param department
	 */
	public void removeDepartment(Department department) {

		// TODO: Since this a bidirectional OneToMany relationship, you should
		// remoce the reference to this object from the other end of the
		// relationship. Uncomment the following line
		//department.assignToStore(null);
		this.departments.remove(department);

	}

	public List<Department> getAllDepartments() {
		return this.departments;
	}

	public List<Customer> getAllCustomers() {
		return this.customers;
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

}
