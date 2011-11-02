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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.observers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.Alarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.EventData;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.statechange.StateChangeEvent;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.fakes.FakeAlarmMapper;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.fakes.FakeStateChangeMapper;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.mapper.AbstractEventMapper;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.mapper.AbstractMapperTest;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.mapper.ApplianceEventMapper;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.mapper.EventMapper;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.mapper.MapperChain;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.observers.ApplianceEventObservable;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.observers.ApplianceEventObserver;

import static org.mockito.Mockito.*;
/**
 * @author windows
 * 
 * 
 * 
 * TODO: 
 * - Go to {@link EventMapper} and follow the TODO for this exercise
 * - Go {@link AbstractEventMapper} and implement the interfaces from {@link ApplianceEventObservable}
 * - Go to this class and find the TODOs
 *  
 */
public class ApplianceEventObservableTest extends AbstractMapperTest {

	@Test
	public void testNotifyAlarm() {

		// Create a new MapperChain
		MapperChain chain = new MapperChain();
		
		//Create observers
		ApplianceEventObserver applianceStore = createEventObserver();
		ApplianceEventObserver applianceLogger= createEventObserver();
		
		EventMapper applianceEventMapper = new ApplianceEventMapper(createApplianceDAO());
		EventMapper stateChangeMapper = new FakeStateChangeMapper();
		EventMapper alarmMapper = new FakeAlarmMapper();
		
		//Attach observers to observables
		
		stateChangeMapper.addObserver(applianceStore);
		stateChangeMapper.addObserver(applianceLogger);
		alarmMapper.addObserver(applianceStore);
		alarmMapper.addObserver(applianceLogger);
		
		
		//Add to chain
		chain.addToChain(applianceEventMapper);
		chain.addToChain(stateChangeMapper);
		chain.addToChain(alarmMapper);

		// create dummy EventData
		EventData eventData = createAlarmEventData();

		chain.doMap(eventData);
		assertNotNull(eventData);
		assertNotNull(eventData.getEvent().getSourceAppliance());
		assertEquals("12.12.12.12", eventData.getEvent().getSourceAppliance().getIpAddress());
		assertTrue(eventData.getEvent() instanceof Alarm);
		
		//Verify that the mocks method onApplianceEvent were called 
		verify(applianceStore).onApplianceEvent(eventData.getEvent());
		//Verify that the mocks method onApplianceEvent were called 
		verify(applianceLogger).onApplianceEvent(eventData.getEvent());
	}

	@Test
	public void testNotifyAttributeChanged() {

		// Create a new MapperChain
		MapperChain chain = new MapperChain();
		
		//Create observers
		ApplianceEventObserver applianceStore = createEventObserver();
		ApplianceEventObserver applianceLogger= createEventObserver();
		
		EventMapper applianceEventMapper = new ApplianceEventMapper(createApplianceDAO());
		EventMapper stateChangeMapper = new FakeStateChangeMapper();
		EventMapper alarmMapper = new FakeAlarmMapper();
		
		//Attach observers to observables
		stateChangeMapper.addObserver(applianceStore);
		stateChangeMapper.addObserver(applianceLogger);
		alarmMapper.addObserver(applianceStore);
		alarmMapper.addObserver(applianceLogger);

		
		
		//Add to chain
		chain.addToChain(applianceEventMapper);
		chain.addToChain(stateChangeMapper);
		chain.addToChain(alarmMapper);

		// create dummy EventData
		EventData eventData = createStateChangeEventData();

		chain.doMap(eventData);
		assertNotNull(eventData);
		assertNotNull(eventData.getEvent().getSourceAppliance());
		assertEquals("12.12.12.12", eventData.getEvent().getSourceAppliance().getIpAddress());
		assertTrue(eventData.getEvent() instanceof StateChangeEvent);
		
		//Verify that the mocks method onApplianceEvent were called 
		verify(applianceStore).onApplianceEvent(eventData.getEvent());
		//Verify that the mocks method onApplianceEvent were called 
		verify(applianceLogger).onApplianceEvent(eventData.getEvent());
	}
	/**
	 * @return
	 */
	private ApplianceEventObserver createEventObserver() {
		return mock(ApplianceEventObserver.class);
		
	}
}
