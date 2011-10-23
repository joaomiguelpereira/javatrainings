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
package eu.jpereira.trainings.designpatterns.structural.flyweight.fakes;

import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.HumiditySensor;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.Sensor;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.TemperatureSensor;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WeatherStationController;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WindSensor;

/**
 * @author jpereira
 * 
 */
public class FakeWeatherStationController extends WeatherStationController {

	/**
	 * @param temperatureSensor2
	 * @param humiditySensor2
	 * @param windSensor2
	 */
	public FakeWeatherStationController(TemperatureSensor temperatureSensor2, HumiditySensor humiditySensor2, WindSensor windSensor2) {
		super(temperatureSensor2, humiditySensor2, windSensor2);
		System.err.println("New Fake WeatherStationController for");
	}

}
