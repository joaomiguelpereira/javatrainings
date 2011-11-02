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

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.ApplianceEvent;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.observers.ApplianceEventObservable;
import eu.jpereira.trainings.designpatterns.behavioral.visitor.observers.ApplianceEventObserver;

/**
 * @author windows
 * 
 *         TODO Exercise: Implement the methods from
 *         {@link ApplianceEventObservable} here in this class
 */
public abstract class AbstractEventMapper implements EventMapper {

	//references of the observers
	private List<ApplianceEventObserver> observers;

	/**
	 * Create new {@link AbstractEventMapper}
	 */
	public AbstractEventMapper() {
		observers = new ArrayList<ApplianceEventObserver>();
	}

	
	/**
	 * Update all observers about a new event
	 * @param event
	 */
	protected void updateObservers(ApplianceEvent event) {
		for (ApplianceEventObserver observer : this.observers) {
			observer.onApplianceEvent(event);
		}
	}

	@Override
	public void addObserver(ApplianceEventObserver observer) {
		this.observers.add(observer);

	}

	@Override
	public void removeObserver(ApplianceEventObserver observer) {
		this.observers.remove(observer);

	}

}
