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

import java.util.Properties;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.LightsCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.PowerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.TrafficLightController;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.exceptions.CouldNotSendCommandException;

/**
 * Abstraction of a traffic light
 * 
 * @author jpereira
 * 
 */
public abstract class TrafficLight {

	// The instance of the controller
	private TrafficLightController controller;

	// The ip address of this traffic light
	private String ipAddress;

	public TrafficLight(String ipAddress) {
		// Delegate instantiation to concrete instances of TrafficController
		this.setIpAddress(ipAddress);
		controller = createDefaultTrafficLightController();

	}

	/**
	 * Factory method to be used by concrete subclasses if they wish to
	 * create it's own instance. Prefer to set the controller after creating this objaet
	 * 
	 * @return instance of a TrafficLightController
	 */
	protected TrafficLightController createDefaultTrafficLightController() {
		return null;
	}

	/**
	 * Factory method for PowerCommands
	 * 
	 * @return
	 */
	protected abstract PowerCommand getPowerOnCommand();

	/**
	 * Factory method for powerOffCommand
	 * 
	 * @return
	 */
	protected abstract PowerCommand getPowerOffCommand();

	/**
	 * Factory method for QueryPowerStatusCommand
	 * 
	 * @return
	 */
	protected abstract PowerCommand getQueryPowerStatusCommand();

	/**
	 * Factory method for set color command
	 * 
	 * @param color
	 * @return
	 */
	protected abstract LightsCommand getSetColorCommand(LightColors color);

	/**
	 * Factory method for querycolorcommand
	 * 
	 * @return
	 */
	protected abstract LightsCommand createQueryColorCommand();

	/**
	 * Factory method for create FlashingQueryCommand
	 * 
	 * @return
	 */
	protected abstract LightsCommand createFlashingQueryCommand();

	/**
	 * Factory methof for Set Flashing command
	 * 
	 * @param flashing
	 * @return
	 */
	protected abstract ControllerCommand createSetFlashingCommand(boolean flashing);

	/**
	 * Send a powerOn command to the controller
	 * 
	 * @throws CouldNotConnectException
	 */
	public void powerOn() throws CouldNotSendCommandException {

		sendPowerCommandToController(getPowerOnCommand());

	}

	/**
	 * Send a powerOff commadn to the controller
	 * 
	 * @throws CouldNotSendCommandException
	 */
	public void powerOff() throws CouldNotSendCommandException {
		sendPowerCommandToController(getPowerOffCommand());

	}

	/**
	 * Send a command to the controller to query powerStatus
	 * 
	 * @return The enum value for current porwerStatux
	 * @throws CouldNotSendCommandException
	 */
	public PowerStatus getPowerStatus() throws CouldNotSendCommandException {

		ControllerCommand queryCommand = getQueryPowerStatusCommand();
		// call and block
		sendPowerCommandToController(queryCommand);

		// Translate message
		return PowerStatus.fromProperties(queryCommand.getResponseProperties());

	}

	/**
	 * Send a command to the controller to set the color
	 * 
	 * @param color
	 * @throws CouldNotSendCommandException
	 */
	public void setColor(LightColors color) throws CouldNotSendCommandException {
		sendLightCommandToController(getSetColorCommand(color));

	}

	/**
	 * Get current color of traffic light
	 * 
	 * @return
	 * @throws CouldNotSendCommandException
	 */
	public LightColors getColor() throws CouldNotSendCommandException {
		ControllerCommand command = createQueryColorCommand();
		sendLightCommandToController(command);
		return LightColors.fromProperties(command.getResponseProperties());
	}

	/**
	 * Send a command to the controller to query the flash status
	 * 
	 * @return TODO
	 * @throws CouldNotSendCommandException
	 */
	public boolean isFlashing() throws CouldNotSendCommandException {
		ControllerCommand command = createFlashingQueryCommand();
		sendLightCommandToController(command);
		return hasPropertySet("flashing", command.getResponseProperties());

	}

	/**
	 * Send a command to the controller to set the flashing status
	 * 
	 * @param b
	 * @throws CouldNotSendCommandException
	 */
	public void setFlashing(boolean flashing) throws CouldNotSendCommandException {
		sendLightCommandToController(createSetFlashingCommand(flashing));
	}

	public void setController(TrafficLightController controller) {
		this.controller = controller;
	}

	/**
	 * Get the IP Address
	 * 
	 * @return
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Once set, cannot change unless through sub-classing
	 * 
	 * @param ipAddress
	 */
	protected void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @param propName
	 * @param responseProperties
	 * @return
	 */
	private boolean hasPropertySet(String propName, Properties responseProperties) {
		boolean ret = false;
		if (responseProperties != null && responseProperties.containsKey(propName)) {
			String value = responseProperties.getProperty(propName);
			ret = value.equals("1");
		}
		return ret;
	}

	/**
	 * @param setColorCommand
	 * @throws CouldNotSendCommandException
	 */
	private void sendLightCommandToController(ControllerCommand command) throws CouldNotSendCommandException {
		try {
			this.controller.sendLightCommand(command);
		} catch (CouldNotConnectException e) {
			throw new CouldNotSendCommandException(e);
		}

	}

	/**
	 * @param command
	 * @throws CouldNotSendCommandException
	 */
	private void sendPowerCommandToController(ControllerCommand command) throws CouldNotSendCommandException {
		try {
			this.controller.sendPowerCommand(command);
		} catch (CouldNotConnectException e) {
			throw new CouldNotSendCommandException(e);
		}

	}

	/**
	 * Enumerate the Light Colors
	 * 
	 * @author jpereira
	 * 
	 */
	public static enum LightColors {
		RED, GREEN, YELLOW, UNKNOW;

		/**
		 * @param responseProperties
		 * @return
		 */
		public static LightColors fromProperties(Properties responseProperties) {
			LightColors color = UNKNOW;
			if (responseProperties != null && responseProperties.containsKey("color")) {
				String value = responseProperties.getProperty("color");
				// Refactor this. Add constructor to enum
				if (value.equalsIgnoreCase("red")) {
					color = RED;
				} else if (value.equalsIgnoreCase("green")) {
					color = GREEN;

				} else if (value.equalsIgnoreCase("yellow")) {
					color = YELLOW;
				}
			}
			return color;

		}
	}

	/**
	 * Enumerate the power status values
	 * 
	 * @author jpereira
	 * 
	 */
	public static enum PowerStatus {
		ON, OFF, UNKNOW;

		/**
		 * @param responseProperties
		 * @return
		 */
		public static PowerStatus fromProperties(Properties responseProperties) {
			PowerStatus status = UNKNOW;
			if (responseProperties != null && responseProperties.containsKey("powerStatus")) {
				// Get the value
				String value = responseProperties.getProperty("powerStatus");
				if (value.equalsIgnoreCase("on")) {
					status = ON;
				} else if (value.equalsIgnoreCase("off")) {
					status = OFF;
				}
			}
			return status;
		}
	}

}
