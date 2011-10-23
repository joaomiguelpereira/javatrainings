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

import java.util.HashMap;
import java.util.Map;

import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.HumiditySensor;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.TemperatureSensor;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WeatherStationController;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WeatherStationControllerFactory;
import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WindSensor;

/**
 * @author jpereira
 * 
 */
public class FakeWeatherStationControllerFactory implements WeatherStationControllerFactory {

	private static volatile WeatherStationControllerFactory instance = null;
	private Map<String, WeatherStationController> controllers;

	// TODO: Remove this variable

	protected FakeWeatherStationControllerFactory() {
		this.controllers = new HashMap<String, WeatherStationController>();
	}

	/**
	 * @return
	 */
	public static WeatherStationControllerFactory instance() {
		if (instance == null) {
			synchronized (FakeWeatherStationControllerFactory.class) {
				if (instance == null) {
					instance = new FakeWeatherStationControllerFactory();
				}
			}
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.creational.flyweight.controller.
	 * WeatherStationControllerFactory#getController(java.lang.String)
	 */
	@Override
	public synchronized WeatherStationController getController(String ipAddress) {
		WeatherStationController controller = null;
		/*
		//Try to get from the map of available instances of controller
		WeatherStationController controller = this.controllers.get(ipAddress);
		//If does not exists, create it
		if (controller == null) {
			
			controller = new FakeWeatherStationController(new TemperatureSensor(), new HumiditySensor(), new WindSensor());
			this.controllers.put(ipAddress, controller);

		}*/
		return controller;
	}

}
