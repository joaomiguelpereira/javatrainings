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
package eu.jpereira.trainings.designpatterns.structural.proxy.controller;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;

/**
 * @author jpereira
 * 
 */
public abstract class TrafficLightController implements ITrafficLightController{

	/**
	 * The IP Address to where this controller wil connect
	 */
	private String ipAddress;

	//Default constructor. Used to use dynamic proxy
	public TrafficLightController() {
		
	}
	/**
	 * Constructor
	 * 
	 * @param ipAddress
	 *            The Ip address to where this controller will connect
	 */
	public TrafficLightController(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @param command
	 */
	public abstract void sendPowerCommand(ControllerCommand command) throws CouldNotConnectException;

	/**
	 * @param mockedSetColorCommand
	 */
	public abstract void sendLightCommand(ControllerCommand command) throws CouldNotConnectException;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
