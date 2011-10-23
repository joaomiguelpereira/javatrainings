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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import eu.jpereira.trainings.designpatterns.structural.flyweight.dao.Dao;
import eu.jpereira.trainings.designpatterns.structural.flyweight.model.City;
import eu.jpereira.trainings.designpatterns.structural.flyweight.representations.JSONWeatherReading;
import eu.jpereira.trainings.designpatterns.structural.flyweight.service.WeatherService;
import eu.jpereira.trainings.designpatterns.structural.flyweight.tranferobject.WeatherReading;



/**
 * @author jpereira
 *
 */
public class FakeHTTPHandler extends AbstractHandler{

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.server.Handler#handle(java.lang.String, org.eclipse.jetty.server.Request, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String out = "Could not get weather";
		//Get params
		String city = request.getParameter("city");
		String latitude = request.getParameter("la") ;
		String longitude = request.getParameter("lo");
		System.out.println("Thread: "+Thread.currentThread()+"Handling request for city: "+city);
		System.out.println("Thread: "+Thread.currentThread()+"Handling request for latitude: "+latitude);
		System.out.println("Thread: "+Thread.currentThread()+"Handling request for longitude: "+longitude);
		
		if (city==null||latitude==null||longitude==null) {
			out = "Please provide city, latitude and longitude. Ex ?city=aveiro&lo=111&la=232";
		} else {
			//Create the service
			WeatherService service = createRestService();
			WeatherReading reading = service.getWeatherReading(city, latitude, longitude);
			if (reading != null) {
				out = new JSONWeatherReading(reading).toString();
			}

		}

		
		
		
		response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(out);
        ((Request)request).setHandled(true);
		
	}

	/**
	 * @return
	 */
	private WeatherService createRestService() {
		return new FakeWeatherService(createFakeDao());
	}

	/**
	 * @return
	 */
	private Dao<City> createFakeDao() {

		return new FakeCityDao();
	}

}
