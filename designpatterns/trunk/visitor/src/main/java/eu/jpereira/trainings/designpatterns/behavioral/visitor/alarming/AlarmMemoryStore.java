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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.alarming;

import java.util.Collection;
import java.util.LinkedList;

import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.Alarm;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.ApplianceEvent;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.EventType;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering.EventFilter;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.observers.ApplianceEventObserver;

/**
 * @author jpereira
 * 
 */
public class AlarmMemoryStore implements ApplianceEventObserver {

	// memory store
	private Collection<Alarm> alarms;

	public AlarmMemoryStore() {
		this.alarms = new LinkedList<Alarm>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.visitor.observers.
	 * ApplianceEventObserver
	 * #onApplianceEvent(eu.jpereira.trainings.designpatterns
	 * .behavioral.visitor.event.ApplianceEvent)
	 */
	@Override
	public void onApplianceEvent(ApplianceEvent event) {
		// Keep alarms only
		if (EventType.ALARM.asAlarm(event) != null) {
			this.alarms.add(EventType.ALARM.asAlarm(event));

		}

	}

	/**
	 * @return
	 */
	public Object getAlarmCount() {
		return this.alarms.size();
	}

	/**
	 * @param filter
	 */
	public void filter(EventFilter filter) {
		// go to each alarm and pass the filter
		for (Alarm alarm : this.alarms) {
			alarm.runFilter(filter);
		}

	}

}
