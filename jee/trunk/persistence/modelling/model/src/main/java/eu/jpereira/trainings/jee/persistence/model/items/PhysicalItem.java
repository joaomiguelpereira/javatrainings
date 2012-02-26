package eu.jpereira.trainings.jee.persistence.model.items;

import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;

//TODO: This domain object should be mapped to the DB. Annotate with the proper annotation
public class PhysicalItem extends SellableItem {

	// TODO: The dimensions object should be mapped to the same table as this
	// object
	private ItemDimensions dimensions;

	public float calculateShippingCosts(PostalAddress toAddress,
			ShippingCalulatorStrategy strategy) {
		return strategy.calculateShippingCosts(toAddress, this.dimensions);
	}

	public void setDimensions(ItemDimensions dimensions) {
		this.dimensions = dimensions;
	}

	public static class Builder extends SellableItem.Builder<PhysicalItem> {

		public Builder withDimensions(ItemDimensions dimensions) {
			this.instance.dimensions = dimensions;
			return this;
		}

		@Override
		protected PhysicalItem createInstance() {
			return new PhysicalItem();
		}

	}
}
