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
import eu.jpereira.trainings.designpatterns.behavioral.state.event.Alarm;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.ApplianceEvent;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.EventData;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.alarm.TemperatureAlarm;
import eu.jpereira.trainings.designpatterns.behavioral.state.mapper.EventMapper;
import eu.jpereira.trainings.designpatterns.behavioral.state.mapper.MapperChain;

/**
 * This object is responsible for Mapping a {@link EventData} into an alarm.
 * This mapper must run after any mapper that can create a
 * {@link ApplianceEvent} with the correct instance of {@link Appliance}
 * 
 * @author jpereira
 * 
 */
public class FakeAlarmMapper implements EventMapper {

	
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

		if ( data.getEvent()==null || data.getEvent().getSourceAppliance()==null) {
			throw new IllegalStateException("Must run any mapper before this in order to fill the event with the righjt appliance");
		}
		
		//check if the event is an alarm
		if (data.getProperty("type").equals("alarm")) {
			Alarm alarm = createAlarm(data.getProperty("alarmName"),data.getEvent().getSourceAppliance());
			alarm.setAditionalInfo(data.getProperty("aditionalInfo"));
			data.setEvent(alarm);
		}
		
		chain.doMap(data);

	}

	/**
	 * @param property
	 * @return
	 */
	private Alarm createAlarm(String property, Appliance appliance) {
		Alarm theAlarm = null;
		//fake object, instantiate this for testing
		if ( property.equals("highTemp")) {
			theAlarm = new TemperatureAlarm(appliance);
		}
		return theAlarm ;
	}

}
