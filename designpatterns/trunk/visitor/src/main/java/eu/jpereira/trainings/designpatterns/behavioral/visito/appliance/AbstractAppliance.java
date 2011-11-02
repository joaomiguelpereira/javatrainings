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
package eu.jpereira.trainings.designpatterns.behavioral.visito.appliance;


/**
 * @author jpereira
 * 
 */
public abstract class AbstractAppliance implements Appliance {

	private String ipAddress;
	private String macAddress;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance
	 * #setIpAddress(java.lang.String)
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance
	 * #setMacAddress(java.lang.String)
	 */
	@Override
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance
	 * #getMacAddress()
	 */
	@Override
	public String getMacAddress() {
		return this.macAddress;
	}

	@Override
	public Object getIpAddress() {

		return this.ipAddress;
	}
	
	
}
