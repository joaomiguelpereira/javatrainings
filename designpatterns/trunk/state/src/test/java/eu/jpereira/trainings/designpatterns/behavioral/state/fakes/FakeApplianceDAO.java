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
package eu.jpereira.trainings.designpatterns.behavioral.state.fakes;

import java.util.HashMap;
import java.util.Map;

import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.Toaster;
import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.dao.ApplianceDAO;
import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceState;

/**
 * @author jpereira
 *
 */
public class FakeApplianceDAO implements ApplianceDAO {

	static Map<String, Appliance> appliances = new HashMap<String, Appliance>();
	
	static {
		Appliance toaster = new Toaster(ApplianceState.OFF);
		toaster.setIpAddress("12.12.12.12");
		toaster.setMacAddress("AA.BB.CC");
		appliances.put(toaster.getMacAddress(), toaster);

	}
	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.dao.ApplianceDAO#findByMacAddress(java.lang.String)
	 */
	@Override
	public Appliance findByMacAddress(String macAddress) {
		
		return appliances.get(macAddress);
	}

}
