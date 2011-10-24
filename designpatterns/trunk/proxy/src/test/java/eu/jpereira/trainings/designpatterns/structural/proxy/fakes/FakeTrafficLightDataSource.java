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

import eu.jpereira.trainings.designpatterns.structural.proxy.TrafficLightsFactory;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight;
import eu.jpereira.trainings.designpatterns.structural.proxy.testconfig.TestConfiguration;

/**
 * @author jpereira
 *
 */
public class FakeTrafficLightDataSource implements TrafficLightsFactory {

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.TrafficLightsFactory#getTrafficLight(java.lang.String)
	 */
	@Override
	public TrafficLight getTrafficLight(String ipAddress) {
		
		return new FakeTrafficLight(ipAddress);
	}

}
