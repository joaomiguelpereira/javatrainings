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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.TemperatureAlarm;

/**
 * @author windows
 *
 */
public class TemperatureAlarmFilter implements EventFilter {

	private List<TemperatureAlarm> results;
	private Long TemperatureThreshold = 0L;
	
	public TemperatureAlarmFilter() {
		this.results = new ArrayList<TemperatureAlarm>();
	}
	
	
	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.EventFilter#filter(eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.Filterable)
	 */
	@Override
	public void filter(Filterable filtearble) {
		
		if (filtearble instanceof TemperatureAlarm) {
			TemperatureAlarm temperatureAlarm = (TemperatureAlarm)filtearble;
			if (temperatureAlarm.getTemperatureValue()>this.getTemperatureThreshold()) {
				this.results.add(temperatureAlarm);
			}
						
		}
	}

	/**
	 * @return the results
	 */
	public List<TemperatureAlarm> getResults() {
		return results;
	}

	/**
	 * @return the temperatureThreshold
	 */
	public Long getTemperatureThreshold() {
		return TemperatureThreshold;
	}

	/**
	 * @param temperatureThreshold the temperatureThreshold to set
	 */
	public void setTemperatureThreshold(Long temperatureThreshold) {
		TemperatureThreshold = temperatureThreshold;
	}

	

}
