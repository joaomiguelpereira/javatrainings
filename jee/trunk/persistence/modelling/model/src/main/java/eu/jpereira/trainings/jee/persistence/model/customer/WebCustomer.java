package eu.jpereira.trainings.jee.persistence.model.customer;

import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;

//TODO: This domain Object should be mapped to the DB
public class WebCustomer extends Customer {

	private String email;

	public String getEmail() {
		return this.email;
	}

	public static class Builder extends Customer.CustomerBuilder<WebCustomer> {

		public Builder withEmail(String email) {
			this.instance.email = email;
			return this;
		}

		@Override
		protected WebCustomer createInstance() {

			return new WebCustomer();
		}

		@Override
		protected void validateObject() throws BuilderRequiredValue {
			if (this.instance.email == null) {
				throw new BuilderRequiredValue(
						"The email is missing and can't build a Customer");
			}
		}

	}

}
