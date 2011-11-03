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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.filtering;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Random;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.visito.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.alarming.AlarmMemoryStore;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.Alarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.HumidityAlarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.TemperatureAlarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.HumidityAlarmFilter;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.TemperatureAlarmFilter;

/**
 * @author jpereira
 * TODO:
 * 
 * Open package eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering and analyze it
 * Open {@link Alarm} and analyze how it's related with the Visitor patterns
 * Open {@link AlarmMemoryStore} and analyze it
 * Open {@link HumidityAlarmFilter} and complete the steps
 * Run the tests
 * 
 * 
 */
public class FilterTest {

	@Test
	public void testTemperatureFilterFilter() {
		AlarmMemoryStore store = createMemoryStore();
		// Create a dummy appliance
		Appliance appliance = mock(Appliance.class);
		// Create a dummy alarms

		// add some alarms to the store by the interface used by Observables
		int testThreshold = 350;
		int count = 0;
		for (int i=0; i< 1000; i++ ) {
			int temp = new Random().nextInt(1000);
			if ( temp > testThreshold ) {
				count++;
			}
			TemperatureAlarm alarm = new TemperatureAlarm(appliance);
			alarm.setTemperatureValue(new Long(temp));
			store.onApplianceEvent(alarm);
			
		}// only allow alarms
		assertEquals(1000, store.getAlarmCount());
		
		//Create an temperature Filter
		TemperatureAlarmFilter filter = new TemperatureAlarmFilter();
		filter.setTemperatureThreshold(new Long(testThreshold));
		
		store.filter(filter);
		assertEquals(count, filter.getResults().size());
		System.out.println("Produced "+count+" alarms with temp higher than "+testThreshold);
		System.out.println("Filtered :"+filter.getResults().size()+" Results");
		
		
	}
	

	@Test
	public void testHumidityFilterFilter() {
		AlarmMemoryStore store = createMemoryStore();
		// Create a dummy appliance
		Appliance appliance = mock(Appliance.class);
		// Create a dummy alarms

		// add some alarms to the store by the interface used by Observables
		int testThreshold = 30;
		int count = 0;
		for (int i=0; i< 1000; i++ ) {
			int humidity = new Random().nextInt(100);
			if ( humidity > testThreshold ) {
				count++;
			}
			HumidityAlarm alarm = new HumidityAlarm(appliance);
			alarm.setHumidityValue(new Float(humidity));
			store.onApplianceEvent(alarm);
			
		}// only allow alarms
		assertEquals(1000, store.getAlarmCount());
		
		//Create an HumidictyFilter Filter
		HumidityAlarmFilter filter = new HumidityAlarmFilter();
		filter.setHumidityThreshold(new Float(testThreshold));
		
		store.filter(filter);
		assertEquals(count, filter.getResults().size());
		System.out.println("Produced "+count+" alarms with temp higher than "+testThreshold);
		System.out.println("Filtered :"+filter.getResults().size()+" Results");
		
		
	}
	
	
	/**
	 * @return
	 */
	private AlarmMemoryStore createMemoryStore() {
		return new AlarmMemoryStore();
	}
}
