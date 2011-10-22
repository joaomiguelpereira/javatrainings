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
public class FakeWeatherStationController implements WeatherStationController {

	
	private Sensor temperatureSensor;
	private Sensor humiditySensor;
	private Sensor windSensor;
	
	
	private String ipAddress;

	/**
	 * @param ipAddress
	 */
	public FakeWeatherStationController(String ipAddress) {
		this.ipAddress = ipAddress;
		//create instances of sensores
		this.temperatureSensor = createTempSensor();
		this.humiditySensor = createHumSensor();
		this.windSensor = createWindSensor();
		System.err.println("New Fake WeatherStationController for IP: "+this.ipAddress);
		
	}

	/**
	 * @return
	 */
	private Sensor createWindSensor() {

		return new WindSensor();
	}

	/**
	 * @return
	 */
	private Sensor createHumSensor() {

		return new HumiditySensor();
	}

	/**
	 * @param ipAddress2 
	 * @return
	 */
	private Sensor createTempSensor() {

		return new TemperatureSensor();
	}

	

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.flyweight.controller.WeatherStationController#getTemperatureValue()
	 */
	@Override
	public String getTemperatureValue() {
		
		return this.temperatureSensor.read(this.ipAddress);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.flyweight.controller.WeatherStationController#getHumidityValue()
	 */
	@Override
	public String getHumidityValue() {
		// TODO Auto-generated method stub
		return this.humiditySensor.read(this.ipAddress);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.flyweight.controller.WeatherStationController#getWindValue()
	 */
	@Override
	public String getWindValue() {

		return this.windSensor.read(this.ipAddress);
	}

}
