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
package eu.jpereira.trainings.designpatterns.structural.flyweight.representations;

import eu.jpereira.trainings.designpatterns.structural.flyweight.tranferobject.WeatherReading;

/**
 * @author jpereira
 *
 */
public class JSONWeatherReading {

	private WeatherReading weatherReading;

	/**
	 * @param weatherReading
	 */
	public JSONWeatherReading(WeatherReading weatherReading) {
		
		this.weatherReading = weatherReading;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("temp: ");
		builder.append("\"");
		builder.append(weatherReading.getTemperature());
		builder.append("\"");

		builder.append(",hum: ");
		builder.append("\"");
		builder.append(weatherReading.getHumidity());
		builder.append("\"");

		builder.append(",wind: ");
		builder.append("\"");
		builder.append(weatherReading.getWind());
		builder.append("\"}");

		return builder.toString(); 
	}
	
	

}
