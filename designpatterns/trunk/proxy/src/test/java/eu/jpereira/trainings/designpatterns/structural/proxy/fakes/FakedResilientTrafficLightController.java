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

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ResilientTrafficLightController;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.TrafficLightController;

/**
 * Testing ResilientTrafficLightController
 * @author jpereira
 *
 */
public class FakedResilientTrafficLightController extends ResilientTrafficLightController {

	/**
	 * @param ipAddress
	 */
	public FakedResilientTrafficLightController(String ipAddress) {
		super(ipAddress);
		
	}

	@Override
	protected TrafficLightController createRealTrafficLightController() {
		
		return new FakeFailureTrafficLightController(new FakeTrafficLightContoller(getIpAddress()));
		
	}
	
	

}
