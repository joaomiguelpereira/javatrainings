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
package eu.jpereira.trainings.designpatterns.behavioral.state.fakes;

import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.ApplianceEvent;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.AttributeChangeEvent;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.EventData;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.statechange.StateChangeEvent;
import eu.jpereira.trainings.designpatterns.behavioral.state.mapper.EventMapper;
import eu.jpereira.trainings.designpatterns.behavioral.state.mapper.MapperChain;

/**
 * Acts upon {@link EventData} and the last {@link ApplianceEvent} to generate
 * {@link StateChangeEvent}. A {@link EventMapper} has to run before to create
 * an event with the right {@link Appliance} instance
 * 
 * @author jpereira
 * 
 */
public class FakeStateChangeMapper implements EventMapper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.mapper.EventMapper
	 * #doMap(eu.jpereira.trainings.designpatterns.behavioral.observer.event.
	 * EventData,
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.event.
	 * ApplianceEvent,
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.mapper
	 * .MapperChain)
	 */
	@Override
	public void doMap(EventData data, MapperChain chain) {
		if (data.getEvent() == null || data.getEvent().getSourceAppliance() == null) {
			throw new IllegalStateException("Must run any mapper before this in order to fill the event with the righjt appliance");
		}
		
		
		if (data.getProperty("type").equals("stateChange")) {
			StateChangeEvent event = createStateChangeEvent(data);
			data.setEvent(event);
		}

		chain.doMap(data);

	}

	/**
	 * @param data
	 * @return
	 */
	private StateChangeEvent createStateChangeEvent(EventData data) {
		// TODO Auto-generated method stub
		AttributeChangeEvent event = new AttributeChangeEvent(data.getEvent().getSourceAppliance());
		
		return event;
	}

}
