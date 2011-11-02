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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.mapper;

import eu.jpereira.trainings.designpatterns.behavioral.visitor.appliance.dao.ApplianceDAO;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.EventData;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.fakes.FakeApplianceDAO;

/**
 * @author windows
 * 
 */
public abstract class AbstractMapperTest {

	/**
	 * @return
	 */
	protected EventData createAlarmEventData() {
		EventData data = new EventData();
		data.setProperty("applianceMacAddress", "AA.BB.CC");
		data.setProperty("type", "alarm");
		data.setProperty("alarmName", "highTemp");
		data.setProperty("aditionalInfo", "400");
		return data;
	}

	/**
	 * @return
	 */
	protected EventData createStateChangeEventData() {
		EventData data = new EventData();
		data.setProperty("applianceMacAddress", "AA.BB.CC");
		data.setProperty("type", "stateChange");
		data.setProperty("attributeName", "temperature");
		data.setProperty("attributeLastValue", "350");
		data.setProperty("attributeNewValue", "400");
		return data;
	}
	
	/**
	 * @return
	 */
	protected ApplianceDAO createApplianceDAO() {
		return new FakeApplianceDAO();
	}


}
