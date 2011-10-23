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
package eu.jpereira.trainings.designpatterns.structural.flyweight.model;


/**
 * @author jpereira
 *
 */
public class WeatherStation {
	

	private String ipAddress;
	private String latitude;
	private String longitude;
	public WeatherStation(String ipAddress, String latitude, String longitude) {
		this.ipAddress = ipAddress;
		this.setLatitude(latitude);
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	protected void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	protected void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getLongitude() {
		return longitude;
	}
	protected void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
