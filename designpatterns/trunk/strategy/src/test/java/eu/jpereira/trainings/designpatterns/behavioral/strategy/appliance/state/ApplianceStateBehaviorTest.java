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
package eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.ApplianceCommunicationException;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.Toaster;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.communication.CommunicationStrategy;

import static org.mockito.Mockito.*;
/**
 * @author jpereira
 * 
 */
public class ApplianceStateBehaviorTest {

	@Test
	public void testOffToOn() throws ApplianceCommunicationException {
		// Toaster is the test we will use to test
		Appliance appliance = createAppliance(ApplianceState.OFF);
		appliance.turnOn();
		assertEquals(ApplianceState.ON, appliance.getState());

	}

	@Test
	public void testOnToStarted() throws ApplianceCommunicationException {
		Appliance appliance = createAppliance(ApplianceState.ON);
		appliance.start();
		assertEquals(ApplianceState.STARTED, appliance.getState());
	}

	@Test
	public void testStartedToStopped() throws ApplianceCommunicationException {
		Appliance appliance = createAppliance(ApplianceState.STARTED);
		appliance.stop();
		assertEquals(ApplianceState.STOPPED, appliance.getState());
	}

	@Test
	public void testStoppedToOff() throws ApplianceCommunicationException {
		Appliance appliance = createAppliance(ApplianceState.STOPPED);
		appliance.turnOff();
		assertEquals(ApplianceState.OFF, appliance.getState());
	}

	/**
	 * @return
	 */
	private Appliance createAppliance(ApplianceState state) {
		//Get the toaster some mocked strate
		CommunicationStrategy mockedStrategy = mock(CommunicationStrategy.class);
		return new Toaster(state, mockedStrategy);
		
	}

}
