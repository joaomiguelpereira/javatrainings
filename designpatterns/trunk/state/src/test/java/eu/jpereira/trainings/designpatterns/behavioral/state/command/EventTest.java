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
package eu.jpereira.trainings.designpatterns.behavioral.state.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.ApplianceCommunicationException;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.Command;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.CouldNotExecuteCommandException;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.Event;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.StartApplianceCommand;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.TurnOnApplianceCommand;

/**
 * @author jpereira
 * 
 */
public class EventTest {

	protected Appliance clock;
	protected Appliance toaster;
	protected Appliance mixer;
	protected Appliance air;

	@Test
	public void testExecuteEvent() throws CouldNotExecuteCommandException, ApplianceCommunicationException {
		Event event = createEvent();
		event.execute();
		verify(clock).start();

		verify(toaster).turnOn();
		verify(clock).start();

		verify(air).turnOn();
		verify(air).start();

		verify(mixer).turnOn();
		verify(mixer).start();

	}

	/**
	 * @return
	 */
	private Event createEvent() {

		// Mocked apliances

		clock = mock(Appliance.class);
		toaster = mock(Appliance.class);

		mixer = mock(Appliance.class);

		air = mock(Appliance.class);
		Command startAlarmClock = new StartApplianceCommand(clock);

		Command turnToasterOn = new TurnOnApplianceCommand(toaster);
		Command startToaster = new StartApplianceCommand(toaster);

		Command turnAirConditionerOn = new TurnOnApplianceCommand(air);
		Command startAirConditioner = new StartApplianceCommand(air);

		Command turnMixerOn = new TurnOnApplianceCommand(mixer);
		Command startMixer = new StartApplianceCommand(mixer);

		return new Event().with(startAlarmClock, turnToasterOn, startToaster, turnAirConditionerOn, startAirConditioner, turnMixerOn, startMixer);
	}
}
