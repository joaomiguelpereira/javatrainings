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
package eu.jpereira.trainings.designpatterns.behavioral.state.command.director;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InOrder;

import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.ApplianceCommunicationException;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.Command;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.Event;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.StartApplianceCommand;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.TurnOnApplianceCommand;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.director.CommandDirector;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.director.DefaulCommandDirector;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.director.ErrorDirectingCommandsException;

/**
 * A Test for {@link DefaulCommandDirector}
 * 
 * @author jpereira
 * 
 */
public class CommandDirectorTest {

	// Mocked
	protected Appliance clock;
	protected Appliance toaster;
	protected Appliance air;
	protected Appliance mixer;
	protected Appliance radio;

	@Test
	public void testCommandDirectorSimple() throws ErrorDirectingCommandsException, ApplianceCommunicationException {
		CommandDirector director = createCommandDirector();
		// create some mocked appliances

		Event event = createEvent();
		// Create commands
		Command otherCommand = new TurnOnApplianceCommand(radio);

		director.addCommand(event, otherCommand);

		// Run the director
		director.run();

		verify(clock).start();
		verify(toaster).turnOn();
		verify(toaster).start();
		verify(air).turnOn();
		verify(air).start();
		verify(mixer).turnOn();
		verify(mixer).start();
	}

	@Test
	public void testCommandFailing() throws ApplianceCommunicationException {
		CommandDirector director = createCommandDirector();
		// create some mocked appliances

		Event event = createEvent();
		// Create commands
		Command otherCommand = new TurnOnApplianceCommand(radio);

		director.addCommand(event, otherCommand);
		// Will simulate an exception from toaster.start
		doThrow(new ApplianceCommunicationException()).when(toaster).start();
		// when(toaster.start())

		// Run the director
		try {
			director.run();
		} catch (ErrorDirectingCommandsException e) {
			// Ok
			// e.printStackTrace();
		}

		InOrder inOrder = inOrder(clock, toaster, clock);

		inOrder.verify(clock).start();// Ok
		inOrder.verify(toaster).turnOn();// Ok
		// verify(ttoaster).start(); //fail

		inOrder.verify(toaster).stop(); // rollback
		inOrder.verify(toaster).turnOff(); // rollback
		inOrder.verify(clock).stop();// Ok

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

		radio = mock(Appliance.class);
		Command startAlarmClock = new StartApplianceCommand(clock);

		Command turnToasterOn = new TurnOnApplianceCommand(toaster);
		Command startToaster = new StartApplianceCommand(toaster);

		Command turnAirConditionerOn = new TurnOnApplianceCommand(air);
		Command startAirConditioner = new StartApplianceCommand(air);

		Command turnMixerOn = new TurnOnApplianceCommand(mixer);
		Command startMixer = new StartApplianceCommand(mixer);

		return new Event().with(startAlarmClock, turnToasterOn, startToaster, turnAirConditionerOn, startAirConditioner, turnMixerOn, startMixer);

	}

	/**
	 * @return
	 */
	protected CommandDirector createCommandDirector() {
	
		
		return new DefaulCommandDirector();
	}
}
