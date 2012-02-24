package eu.jpereira.trainings.jee.persistence.model.items;

import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;


/**
 * Strategy for calculating the cost of shipping
 * @author jee
 *
 */
public class ShippingCalulatorStrategy {

	
	public Integer calculateShippingCosts(PostalAddress address, ItemDimensions dimensions) {
		//Dummy algorithm
		return dimensions.getWeigth()*10;
		
	}
}
