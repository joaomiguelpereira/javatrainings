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
package eu.jpereira.trainings.designpatterns.structural.proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.proxy.fakes.FakeTrafficLightFactory;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight.LightColors;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight.PowerStatus;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.exceptions.CouldNotSendCommandException;
import eu.jpereira.trainings.designpatterns.structural.proxy.testconfig.TestConfiguration;

/**
 * @author jpereira
 * 
 */
public class TrafficLightsManagerTest {

	@Before
	public void setUp() {
		TestConfiguration.fakeFailuresInController = true;
	}

	@Test
	public void testManagePower() throws CouldNotSendCommandException {
		TrafficLightsManager manager = createTrafficLightsManager();
		TrafficLight tl = manager.getTrafficLight("127.0.0.1");

		assertEquals(PowerStatus.OFF, tl.getPowerStatus());
		// set on
		tl.powerOn();
		assertEquals(PowerStatus.ON, tl.getPowerStatus());
		// set off
		tl.powerOff();
		assertEquals(PowerStatus.OFF, tl.getPowerStatus());
	}

	@Test
	public void testManageLights() throws CouldNotSendCommandException {
		TrafficLightsManager manager = createTrafficLightsManager();
		TrafficLight tl = manager.getTrafficLight("127.0.0.1");

		// get color
		assertEquals(LightColors.UNKNOW, tl.getColor());
		// change color
		tl.setColor(LightColors.GREEN);
		assertEquals(LightColors.GREEN, tl.getColor());

		// test flashing
		assertFalse(tl.isFlashing());
		// set flashing
		tl.setFlashing(true);
		assertTrue(tl.isFlashing());
	}

	/**
	 * @return
	 */
	protected TrafficLightsManager createTrafficLightsManager() {
		TrafficLightsManager manager = new TrafficLightsManager(new FakeTrafficLightFactory());
		return manager;
	}
}
