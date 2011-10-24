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
package eu.jpereira.trainings.designpatterns.structural.proxy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.LightsCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.PowerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.TrafficLightController;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight.LightColors;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight.PowerStatus;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.exceptions.CouldNotSendCommandException;

/**
 * @author jpereira
 * 
 */
public class TrafficLightTest {

	private TrafficLightController mockedTrafficLightController;
	private PowerCommand mockedPowerOnCommand;
	private PowerCommand mockedPowerOffCommand;
	private PowerCommand mockedQueryPowerStatusCommand;
	
	private LightsCommand mockedSetColorCommand;
	private LightsCommand mockedQueryColorCommand;
	private LightsCommand mockedFlashingQueryCommand;
	private LightsCommand mockedSetFlashingCommand;

	@Test
	public void testPowerOn() throws CouldNotSendCommandException, CouldNotConnectException {
		TrafficLight sut = createTrafficLight();
		// exercise the Abstraction
		sut.powerOn();
		// just verify that mockedTrafficController was called
		verify(this.mockedTrafficLightController).sendPowerCommand(this.mockedPowerOnCommand);
		//

	}

	@Test(expected = CouldNotSendCommandException.class)
	public void testErrorPoweringOn() throws CouldNotSendCommandException, CouldNotConnectException {
		TrafficLight sut = createTrafficLight();

		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendPowerCommand(this.mockedPowerOnCommand);
		// exercise the Abstraction
		sut.powerOn();

	}

	@Test
	public void testPowerOff() throws CouldNotSendCommandException, CouldNotConnectException {
		TrafficLight sut = createTrafficLight();
		// exercise the Abstraction
		sut.powerOff();
		// just verify that mockedTrafficController was called
		verify(this.mockedTrafficLightController).sendPowerCommand(this.mockedPowerOffCommand);
		//

	}

	@Test(expected = CouldNotSendCommandException.class)
	public void testErrorPoweringOff() throws CouldNotSendCommandException, CouldNotConnectException {
		TrafficLight sut = createTrafficLight();

		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendPowerCommand(this.mockedPowerOffCommand);
		// exercise the Abstraction
		sut.powerOff();

	}

	@Test
	public void testGetPowerStatus() throws CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();

		// Stubb
		when(this.mockedQueryPowerStatusCommand.getResponseProperties()).thenReturn(new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				setProperty("powerStatus", "on");
			}
		});
		PowerStatus status = sut.getPowerStatus();
		assertNotNull(status);
		assertEquals(TrafficLight.PowerStatus.ON, status);

	}

	@Test(expected = CouldNotSendCommandException.class)
	public void testGetPowerStatusInError() throws CouldNotSendCommandException, CouldNotConnectException {
		TrafficLight sut = createTrafficLight();

		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendPowerCommand(this.mockedQueryPowerStatusCommand);
		sut.getPowerStatus();
	}

	@Test
	public void testGetColor() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();

		// Stubb
		when(this.mockedQueryColorCommand.getResponseProperties()).thenReturn(new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				setProperty("color", "red");
			}
		});
		TrafficLight.LightColors color = sut.getColor();
		assertNotNull(color);

		assertEquals(LightColors.RED, color);

	}
	
	@Test(expected = CouldNotSendCommandException.class)
	public void testGetColorInError() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();
		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendLightCommand(this.mockedQueryColorCommand);
		sut.getColor();

	}

	@Test
	public void testSetColor() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();
		sut.setColor(LightColors.GREEN);

		verify(this.mockedTrafficLightController).sendLightCommand(this.mockedSetColorCommand);

	}

	@Test(expected = CouldNotSendCommandException.class)
	public void testSetColorInError() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();
		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendLightCommand(this.mockedSetColorCommand);
		sut.setColor(LightColors.GREEN);
	}
	
	
	@Test
	public void testGetFlashing() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();

		// Stub
		when(this.mockedFlashingQueryCommand.getResponseProperties()).thenReturn(new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4296460129710512715L;

			{
				setProperty("flashing", "1");
			}
		});
			assertTrue(sut.isFlashing());
	}
	
	@Test(expected=CouldNotSendCommandException.class)
	public void testGetFlashingInError() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();

		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendLightCommand(this.mockedFlashingQueryCommand);
		sut.isFlashing();

	}
	
	@Test(expected=CouldNotSendCommandException.class)
	public void testSetFlashingInError() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();
		
		doThrow(new CouldNotConnectException()).when(this.mockedTrafficLightController).sendLightCommand(this.mockedSetFlashingCommand);
		sut.setFlashing(true);
	}
	
	@Test
	public void testSetFlashing() throws CouldNotConnectException, CouldNotSendCommandException {
		TrafficLight sut = createTrafficLight();
		
		sut.setFlashing(true);

		verify(this.mockedTrafficLightController).sendLightCommand(this.mockedSetFlashingCommand);

	}

	

	/**
	 * @return
	 */
	protected TrafficLight createTrafficLight() {

		// create a mock for a controller
		this.mockedTrafficLightController = mock(TrafficLightController.class);
		this.mockedPowerOnCommand = mock(PowerCommand.class);
		this.mockedPowerOffCommand = mock(PowerCommand.class);
		this.mockedQueryPowerStatusCommand = mock(PowerCommand.class);
		this.mockedSetColorCommand = mock(LightsCommand.class);
		this.mockedQueryColorCommand = mock(LightsCommand.class);
		this.mockedFlashingQueryCommand = mock(LightsCommand.class);
		this.mockedSetFlashingCommand = mock(LightsCommand.class);

		TrafficLight testInstance = new TrafficLight("127.0.0.1") {
			@Override
			protected TrafficLightController createDefaultTrafficLightController() {
				return mockedTrafficLightController;
			}

			@Override
			protected PowerCommand getPowerOnCommand() {

				return mockedPowerOnCommand;
			}

			@Override
			protected PowerCommand getPowerOffCommand() {

				return mockedPowerOffCommand;
			}

			@Override
			protected PowerCommand getQueryPowerStatusCommand() {

				return mockedQueryPowerStatusCommand;
			}

			@Override
			protected LightsCommand getSetColorCommand(LightColors color) {

				return mockedSetColorCommand;
			}

			@Override
			protected LightsCommand createQueryColorCommand() {

				return mockedQueryColorCommand;
			}

			@Override
			protected LightsCommand createFlashingQueryCommand() {

				return mockedFlashingQueryCommand;
			}

			@Override
			protected ControllerCommand createSetFlashingCommand(boolean flashing) {
				return mockedSetFlashingCommand;
			}

		};
		return testInstance;

	}
}
