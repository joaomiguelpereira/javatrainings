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

import java.lang.reflect.Method;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;

/**
 * @author jpereira
 * 
 */
public class ResilientTrafficLightController extends TrafficLightController {

	//This is a reference to a real subject
	private TrafficLightController realTrafficLightController;
	
	//Specific state for the proxy
	private int retries = 3; // Default value
	private long msBetweenRetries = 1000; // 1 second defaulr;

	/**
	 * Create a new TrafficLightController
	 * @param ipAddress The IP Address to open a socket
	 */
	public ResilientTrafficLightController(String ipAddress) {
		super(ipAddress);
		this.realTrafficLightController = createRealTrafficLightController();
	}

	/**
	 * 
	 * @param ipAddress The IP Address to open a socket
	 * @param retries The maximum number of retries, after which the exception is rethrown
	 * @param timeoutBetweenRetries Milliseconds to wait before retry
	 */
	public ResilientTrafficLightController(String ipAddress, int retries, long timeoutBetweenRetries) {
		super(ipAddress);
		this.retries = retries;
		this.msBetweenRetries = timeoutBetweenRetries;
		this.realTrafficLightController = createRealTrafficLightController();
	}

	/**
	 * Factory method to create the real object. Can be overrided by sub-classes
	 * to provide another implementation
	 * 
	 * @return A reference to the Real Subject
	 */
	protected TrafficLightController createRealTrafficLightController() {
		return new GenericTrafficLightController(this.getIpAddress());
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
		//Proxy clients will run this code
		int failures = 0;
		boolean success = false;
		Exception lastExeption = null;
		while(!success){

			try {
				//Delegate to the real sibject
				this.realTrafficLightController.sendPowerCommand(command);
				success=true;
			} catch (Exception e) {
				failures++;
				System.err.println("Retrying Failure: " + failures);
				lastExeption = e;
			}

			if (failures > retries) {
				throw new CouldNotConnectException(lastExeption);
			}
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
		//The same as sendPowerCommand
		int failures = 0;
		boolean success = false;
		Exception lastExeption = null;

		while (!success) {

			try {
				this.realTrafficLightController.sendLightCommand(command);
				success = true;
			} catch (Exception e) {

				failures++;
				System.err.println("Retrying Failure: " + failures);
				lastExeption = e;
				try {
					Thread.sleep(this.msBetweenRetries);
				} catch (InterruptedException e1) {
					//just log it
					System.err.println(e.getMessage());
				}
			}

			if (failures == retries) {
				throw new CouldNotConnectException(lastExeption);
			}
		}

	}
	
}
