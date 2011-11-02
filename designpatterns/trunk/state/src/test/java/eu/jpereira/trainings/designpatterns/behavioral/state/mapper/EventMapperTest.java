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
package eu.jpereira.trainings.designpatterns.behavioral.state.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.dao.ApplianceDAO;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.Alarm;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.EventData;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.statechange.StateChangeEvent;
import eu.jpereira.trainings.designpatterns.behavioral.state.fakes.FakeAlarmMapper;
import eu.jpereira.trainings.designpatterns.behavioral.state.fakes.FakeApplianceDAO;
import eu.jpereira.trainings.designpatterns.behavioral.state.fakes.FakeStateChangeMapper;
import eu.jpereira.trainings.designpatterns.behavioral.state.mapper.ApplianceEventMapper;
import eu.jpereira.trainings.designpatterns.behavioral.state.mapper.MapperChain;

/**
 * @author jpereira
 * 
 */
public class EventMapperTest {

	@Test
	public void testAlarm() {

		// Create a new MapperChain
		MapperChain chain = new MapperChain();

		chain.addToChain(new ApplianceEventMapper(createApplianceDAO()));
		chain.addToChain(new FakeStateChangeMapper());
		chain.addToChain(new FakeAlarmMapper());

		// create dummy EventData
		EventData eventData = createAlarmEventData();

		chain.doMap(eventData);
		assertNotNull(eventData);
		assertNotNull(eventData.getEvent().getSourceAppliance());
		assertEquals("12.12.12.12", eventData.getEvent().getSourceAppliance().getIpAddress());
		assertTrue(eventData.getEvent() instanceof Alarm);
	}

	
	@Test
	public void testStateChange() {

		// Create a new MapperChain
		MapperChain chain = new MapperChain();

		chain.addToChain(new ApplianceEventMapper(createApplianceDAO()));
		chain.addToChain(new FakeStateChangeMapper());
		chain.addToChain(new FakeAlarmMapper());

		// create dummy EventData
		EventData eventData = createStateChangeEventData();

		chain.doMap(eventData);
		assertNotNull(eventData);
		assertNotNull(eventData.getEvent().getSourceAppliance());
		assertEquals("12.12.12.12", eventData.getEvent().getSourceAppliance().getIpAddress());

		assertTrue(eventData.getEvent() instanceof StateChangeEvent);
	}
	

	/**
	 * @return
	 */
	private ApplianceDAO createApplianceDAO() {
		return new FakeApplianceDAO();
	}

	/**
	 * @return
	 */
	private EventData createAlarmEventData() {
		EventData data = new EventData();
		data.setProperty("applianceMacAddress", "AA.BB.CC");
		data.setProperty("type", "alarm");
		data.setProperty("alarmName", "highTemp");
		data.setProperty("aditionalInfo", "400");
		return data;
	}
	
	/**
	 * @return
	 */
	private EventData createStateChangeEventData() {
		EventData data = new EventData();
		data.setProperty("applianceMacAddress", "AA.BB.CC");
		data.setProperty("type", "stateChange");
		data.setProperty("attributeName", "temperature");
		data.setProperty("attributeLastValue", "350");
		data.setProperty("attributeNewValue", "400");
		return data;
	}

}
