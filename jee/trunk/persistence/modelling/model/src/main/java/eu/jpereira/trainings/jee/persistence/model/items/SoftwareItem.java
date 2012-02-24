package eu.jpereira.trainings.jee.persistence.model.items;

import javax.persistence.Entity;

@Entity
public class SoftwareItem extends DigitalItem {

	private String activationKey;

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public static class Builder extends DigitalItem.Builder<SoftwareItem> {

		public Builder withActivationKey(String activationKey) {
			this.instance.activationKey = activationKey;
			return this;
		}

		@Override
		protected SoftwareItem createInstance() {
			return new SoftwareItem();
		}

	}

}
