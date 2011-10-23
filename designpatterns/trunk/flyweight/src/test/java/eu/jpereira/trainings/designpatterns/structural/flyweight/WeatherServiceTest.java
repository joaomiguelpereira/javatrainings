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
package eu.jpereira.trainings.designpatterns.structural.flyweight;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.flyweight.controller.WeatherStationController;
import eu.jpereira.trainings.designpatterns.structural.flyweight.dao.CityDao;
import eu.jpereira.trainings.designpatterns.structural.flyweight.fakes.FakeWeatherService;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.City;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.WeatherStation;
import eu.jpereira.trainings.designpatterns.structural.flyweight.service.WeatherService;
import eu.jpereira.trainings.designpatterns.structural.flyweight.tranferobject.WeatherReading;

/**
 * @author jpereira
 * 
 */
public class WeatherServiceTest {

	private CityDao mockedCityDao;
	private City mockedCity;
	private WeatherStation mockedWeatherStation;
	private WeatherStationController mockedWeatherStationController;

	@Test
	public void testGetWeatherReading() {
		WeatherService service = createWeatherService();
		// City dao will be called to get

		String city = "aveiro";
		String dummyLatitude = "1232";
		String dummyLongitude = "332";

		// stub returns
		when(mockedCityDao.findBy("city", city)).thenReturn(mockedCity);
		when(mockedCity.findNearestStation(dummyLatitude, dummyLongitude)).thenReturn(mockedWeatherStation);
		//when(mockedWeatherStation.getControler()).thenReturn(mockedWeatherStationController);

		
		when(mockedWeatherStationController.getHumidityValue("22.22.22.22")).thenReturn("22");
		when(mockedWeatherStationController.getTemperatureValue("22.22.22.22")).thenReturn("22");
		when(mockedWeatherStationController.getWindValue("22.22.22.22")).thenReturn("22");

		WeatherReading reading = service.getWeatherReading(city, dummyLatitude, dummyLongitude);
		assertNotNull(reading);
	}

	/**
	 * @return
	 */
	private WeatherService createWeatherService() {

		mockedCity = mock(City.class);
		mockedCityDao = mock(CityDao.class);
		mockedWeatherStation = mock(WeatherStation.class);
		mockedWeatherStationController = mock(WeatherStationController.class);

		WeatherService service = new FakeWeatherService(mockedCityDao);
		return service;
	}

}
