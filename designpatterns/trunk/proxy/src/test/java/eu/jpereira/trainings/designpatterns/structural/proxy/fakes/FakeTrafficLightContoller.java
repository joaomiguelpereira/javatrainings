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
package eu.jpereira.trainings.designpatterns.structural.proxy.fakes;

import java.util.Properties;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.TrafficLightController;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;

/**
 * This class emulates the communication with the microcontroller. 
 * Add also logic to emulate failures
 * @author jpereira
 * 
 */
public class FakeTrafficLightContoller extends TrafficLightController {

	
	/**
	 * @param ipAddress
	 */
	public FakeTrafficLightContoller(String ipAddress) {
		super(ipAddress);

	}

	// Traffic light properties
	private Properties powerSimulatorProperties = new Properties();
	private Properties lightSimulatorProperties = new Properties();

	{
		this.lightSimulatorProperties.setProperty("color", "NA");
		
		this.lightSimulatorProperties.setProperty("flashing", "0");
		
		
		this.powerSimulatorProperties.setProperty("powerStatus", "off");
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.controller.
	 * TrafficLightController
	 * #sendPowerCommand(eu.jpereira.trainings.designpatterns
	 * .structural.proxy.controller.ControllerCommand)
	 */
	@Override
	public void sendPowerCommand(ControllerCommand command) throws CouldNotConnectException {
		// get key
		String key = command.getKey();
		if (command.getType().equals(ControllerCommand.Type.GET)) {
			command.getResponseProperties().setProperty(key, this.powerSimulatorProperties.getProperty(key));
		} else {
			this.powerSimulatorProperties.setProperty(key, command.getValue());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.controller.
	 * TrafficLightController
	 * #sendLightCommand(eu.jpereira.trainings.designpatterns
	 * .structural.proxy.controller.ControllerCommand)
	 */
	@Override
	public void sendLightCommand(ControllerCommand command) throws CouldNotConnectException {

		// get key
		String key = command.getKey();
		if (command.getType().equals(ControllerCommand.Type.GET)) {
			command.getResponseProperties().setProperty(key, this.lightSimulatorProperties.getProperty(key));
		} else {
			this.lightSimulatorProperties.setProperty(key, command.getValue());
		}

	}

}
