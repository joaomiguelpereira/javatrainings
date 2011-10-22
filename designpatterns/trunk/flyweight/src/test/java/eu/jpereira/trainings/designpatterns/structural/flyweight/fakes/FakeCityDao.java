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

import eu.jpereira.trainings.designpatterns.structural.flyweight.dao.Dao;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.City;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.WeatherStation;

/**
 * @author jpereira
 * 
 */
public class FakeCityDao implements Dao<City> {

	// dummy in Memory DB
	private static Map<String, City> cities = new HashMap<String, City>();

	static {
		// add a dummy overrided city

		City aveiro = new City() {

			private String latitude = "222";
			private String longitude ="22";
			private String ipAddress ="22.22.22.22";


			WeatherStation station = new WeatherStation(ipAddress,latitude,longitude);

			@Override
			public WeatherStation findNearestStation(String latitude, String longitude) {
				// Create allways the same

				return station;
			}
		};

		cities.put("aveiro", aveiro);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.creational.flyweight.dao.Dao#findBy
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public City findBy(String property, String value) {
		// See for each property where it should look from
		return cities.get(value);

	}

}
