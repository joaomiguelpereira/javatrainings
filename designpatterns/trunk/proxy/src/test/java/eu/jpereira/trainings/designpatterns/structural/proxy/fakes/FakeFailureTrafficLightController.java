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

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.TrafficLightController;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;

/**
 * @author jpereira
 * 
 */
public class FakeFailureTrafficLightController extends TrafficLightController {

	private TrafficLightController delegate;
	private static int MAX_FAILURES = 3;
	private int failures = 0;

	/**
	 * @param fakeTrafficLightContoller
	 */
	public FakeFailureTrafficLightController(TrafficLightController delegate) {
		super(delegate.getIpAddress());
		this.delegate = delegate;

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
		simulateFailure();
		// delegate

		delegate.sendPowerCommand(command);

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
		simulateFailure();
		delegate.sendLightCommand(command);

	}

	/**
	 * @throws CouldNotConnectException
	 * 
	 */
	private void simulateFailure() throws CouldNotConnectException {
		
		if ( failures < MAX_FAILURES && (System.currentTimeMillis() % 2 == 0) ) {
			failures++;
			System.err.println("Failing...."+ failures);
			throw new CouldNotConnectException("Faked (even) exception...");
		}

	}

}
