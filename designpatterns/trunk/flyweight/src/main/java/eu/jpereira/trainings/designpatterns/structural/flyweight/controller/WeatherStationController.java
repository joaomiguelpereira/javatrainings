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
package eu.jpereira.trainings.designpatterns.structural.flyweight.controller;

/**
 * @author jpereira
 *
 */
public abstract class WeatherStationController{

	private Sensor temperatureSensor;
	private Sensor humiditySensor;
	private Sensor windSensor;
	
	/**
	 * 
	 * @param temperatureSensor
	 * @param humiditySensor
	 * @param windSensor
	 */
	public WeatherStationController(TemperatureSensor temperatureSensor, HumiditySensor humiditySensor, WindSensor windSensor) {
		this.humiditySensor = humiditySensor;
		this.temperatureSensor = temperatureSensor;
		this.windSensor = windSensor;
	}
	
	/**
	 * @return
	 */
	public String getTemperatureValue(String ipAddress) {
		return this.temperatureSensor.read(ipAddress);
	}

	/**
	 * @return
	 */
	public String getHumidityValue(String ipAddress) {
		return this.humiditySensor.read(ipAddress);
	}

	/**
	 * @return
	 */
	public String getWindValue(String ipAddress) {
		return this.windSensor.read(ipAddress);
	}

}
