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
package eu.jpereira.trainings.designpatterns.behavioral.state.interpreter;

import eu.jpereira.trainings.designpatterns.behavioral.state.event.EventData;

/**
 * Given an string with JSON format, this object will interpret it and create a
 * new instance of {@link EventData}
 * 
 * @author jpereira
 * 
 */
public class JSONEventDataInterpreter implements EventDataInterpreter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.interpreter.
	 * EventInterpreter#interpret(java.lang.String)
	 */
	@Override
	public EventData interpret(String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
