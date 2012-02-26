package eu.jpereira.trainings.jee.persistence.model.customer;

import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;



//TODO: This domain object should be mapped to the DB
public class LocalCustomer extends Customer {

	
	private String customerCardNumber;

	public String getCustomerCardNumber() {
		return customerCardNumber;
	}

	public void setCustomerCardNumber(String customerCardNumber) {
		this.customerCardNumber = customerCardNumber;
	}
	
	
	
	public static class Builder extends Customer.CustomerBuilder<LocalCustomer>{

		@Override
		protected LocalCustomer createInstance() {
			return new LocalCustomer();
		}

		public Builder withCardNumber(String cardNumber) {
			this.instance.customerCardNumber = cardNumber;
			return this;
		}
		@Override
		protected void validateObject() throws BuilderRequiredValue {
			if (this.instance.customerCardNumber==null) {
				throw new BuilderRequiredValue("customerCardNumber is required");
			}
			
		}
		
		
		
	}
	
}
