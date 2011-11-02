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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.alarming;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.visito.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.HumidityAlarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.LowBateryAlarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.TemperatureAlarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.statechange.StateChangeEvent;
/**
 * @author jpereira
 *
 */
public class AlarmMemoryStoreTest {

	
	@Test
	public void testStore() {
		AlarmMemoryStore store = createMemoryStore();
		//Create a dummy appliance
		Appliance appliance = mock(Appliance.class);
		//Create a dummy alarms
		
		//add some alarms to the store by the interface used by Observables
		store.onApplianceEvent(new HumidityAlarm(appliance));
		store.onApplianceEvent(new TemperatureAlarm(appliance));
		store.onApplianceEvent(new LowBateryAlarm(appliance));
		store.onApplianceEvent(new StateChangeEvent(appliance));
		store.onApplianceEvent(new StateChangeEvent(appliance));

		//only allow alarms
		assertEquals(3, store.getAlarmCount());
		
	}

	/**
	 * @return
	 */
	private AlarmMemoryStore createMemoryStore() {
		return new AlarmMemoryStore();
	}
}
