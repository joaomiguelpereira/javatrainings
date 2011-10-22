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
package eu.jpereira.trainings.designpatterns.structural.flyweight.service;

import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WeatherStationController;
import eu.jpereira.trainings.designpatterns.structural.flyweight.dao.Dao;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.City;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.WeatherStation;
import eu.jpereira.trainings.designpatterns.structural.flyweight.tranferobject.WeatherReading;

/**
 * @author jpereira
 *
 */
public class DefaultWeatherService implements WeatherService {

	private Dao<City> dao;

	/**
	 * @param dao
	 */
	public DefaultWeatherService(Dao<City> dao) {
	 this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.flyweight.service.WeatherService#getWeatherReading(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public WeatherReading getWeatherReading(String cityName, String latitude, String longitude) {

		WeatherReading reading = null;
		WeatherStationController controller = null;
		//Find the city 
		City city = dao.findBy("city", cityName);
		
		if (city!=null) {
			//Lookup for the neareast station
			WeatherStation station= city.findNearestStation(latitude,longitude);
			if (station!=null){
				controller = station.getControler();
				 reading = readStationController(controller);
			}
		}
		return reading;
	}

	/**
	 * @param controller 
	 * @return
	 */
	private WeatherReading readStationController(WeatherStationController controller) {
		//create a thread 
		
		String temperature = controller.getTemperatureValue();
		String humidity = controller.getHumidityValue();
		String wind = controller.getWindValue();
		WeatherReading reading = new WeatherReading(temperature, humidity, wind);
		return reading;
	}
	

}