package eu.jpereira.trainings.jee.persistence.model.items;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;

@Entity
public class PhysicalItem extends SellableItem {

	@Embedded
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
