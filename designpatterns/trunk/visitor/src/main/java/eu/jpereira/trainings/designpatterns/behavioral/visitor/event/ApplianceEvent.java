/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.behavioral.visitor.event;

import eu.jpereira.trainings.designpatterns.behavioral.visito.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.Filterable;

/**
 * Defines the interface for represent event sent from appliances
 * @author jpereira
 *
 */
public abstract class ApplianceEvent implements Filterable {
	
	
	private Appliance sourceAppliance;
	
	public ApplianceEvent(Appliance sourceAppliance) {
		this.sourceAppliance = sourceAppliance;
	}
	/**
	 * get the source appliance of the event
	 * @return an instance of {@link Appliance} representing the physical appliance
	 */
	public Appliance getSourceAppliance() {
		return this.sourceAppliance;
	}
	/**
	 * @param appliance
	 */
	public void setSourceAppliance(Appliance appliance) {
		this.sourceAppliance = appliance;
		
	}
	/**
	 * Get the type of event
	 * @see EventType
	 * @return the event type of this event
	 */
	public abstract EventType getType();
	

}
