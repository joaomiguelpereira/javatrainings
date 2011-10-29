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
package eu.jpereira.trainings.designpatterns.behavioral.command.model.command;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance;

/**
 * Represents a request to be sent to any {@link DBServerInstance}
 * 
 * @author jpereira
 * 
 */
//TODO: EXERCISE: make class implementing Command
public abstract  class DBServerInstanceCommand{

	// The receiver object
	protected DBServerInstance receiver;

	/**
	 * Create a new instance of a command having as target the receiver
	 * 
	 * @param the
	 *            instance of {@link DBServerInstance} that will handles the
	 *            request represented by this command
	 */
	public DBServerInstanceCommand(DBServerInstance receiver) {
		this.receiver = receiver;
	}

}
