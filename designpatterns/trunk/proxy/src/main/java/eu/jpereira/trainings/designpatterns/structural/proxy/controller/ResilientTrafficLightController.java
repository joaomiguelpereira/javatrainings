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
public class ResilientTrafficLightController extends TrafficLightController {

	private TrafficLightController realTrafficLightController;
	private int retries = 3; // Default value
	private long msBetweenRetries = 1000; // 1 second defaulr;

	/**
	 * @param ipAddress
	 */
	public ResilientTrafficLightController(String ipAddress) {
		super(ipAddress);
		this.realTrafficLightController = createRealTrafficLightController();
	}

	public ResilientTrafficLightController(String ipAddress, int retries, long timeoutBetweenRetries) {
		super(ipAddress);
		this.retries = retries;
		this.msBetweenRetries = timeoutBetweenRetries;
		this.realTrafficLightController = createRealTrafficLightController();
	}

	/**
	 * Factory method to create the real object. Can be overriden by sub classes
	 * to provide another implementation
	 * 
	 * @return
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
		int failures = 0;
		boolean success = false;
		Exception lastExeption = null;
		
		while(!success){

			try {
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
