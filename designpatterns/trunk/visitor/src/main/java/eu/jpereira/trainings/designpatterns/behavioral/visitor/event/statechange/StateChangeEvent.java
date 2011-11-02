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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.event.statechange;

import eu.jpereira.trainings.designpatterns.behavioral.visito.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.ApplianceEvent;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.EventType;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.EventFilter;

/**
 * @author jpereira
 *
 */
public class StateChangeEvent extends ApplianceEvent {

	/**
	 * @param sourceAppliance
	 */
	public StateChangeEvent(Appliance sourceAppliance) {
		super(sourceAppliance);

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.visitor.event.ApplianceEvent#getType()
	 */
	@Override
	public EventType getType() {
		return  EventType.STATE_CHANGE;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.Filterable#runFilter(eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.EventFilter)
	 */
	@Override
	public void runFilter(EventFilter filter) {
		filter.filter(this);
		
	}

	
	
}
