package eu.jpereira.trainings.jee.persistence.model.customer;


public abstract class CustomerBuilder<T extends Customer> {

	protected T instance;
	
	public CustomerBuilder<T> withFirstName(String firstName) {
		this.instance.firstName = firstName;
		return this;
	}
	
	
	
	
}
