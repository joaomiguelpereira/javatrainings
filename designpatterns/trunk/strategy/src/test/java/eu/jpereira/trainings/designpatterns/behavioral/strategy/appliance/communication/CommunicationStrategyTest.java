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
package eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.communication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.ApplianceCommunicationException;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.Toaster;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.state.ApplianceState;

import static org.mockito.Mockito.*;

/**
 * @author jpereira
 * 
 */
public class CommunicationStrategyTest {
	@Test
	public void testOffToOn() throws ApplianceCommunicationException {
		CommunicationStrategy strategy = mock(CommunicationStrategy.class);
		// Toaster is the test we will use to test
		Appliance appliance = createAppliance(ApplianceState.OFF, strategy);
		appliance.turnOn();
		assertEquals(ApplianceState.ON, appliance.getState());
		
		//The strategy must been called
		verify(strategy).connect(any(ConnectionProperties.class));
		verify(strategy).sendRequest(any(Request.class));
		verify(strategy).disconnect();
		

	}

	/**
	 * @return
	 */
	private Appliance createAppliance(ApplianceState state,CommunicationStrategy strategy) {
		
		return new Toaster(state, strategy);
		
	}
}
