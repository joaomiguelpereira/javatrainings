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
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.results.DBServerInstanceResult;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;

/**
 * Encapsulates a start instance request
 * @author jpereira
 *
 */
public class StartInstanceCommand extends DBServerInstanceCommand {

	
	/**
	 * create a new instance of {@link DBServerInstanceCommand} 
	 * @param receiver the instance that will handles the Start command
	 */
	public StartInstanceCommand(DBServerInstance receiver) {
		super(receiver);

	}

	//TODO: EXERCISE: Uncomment 
	/*
	@Override
	public void execute() throws CouldNotConnectException {
		receiver.startInstance();
	}*/

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.command.Command#getResult()
	 */
	//TODO: EXERCISE: Uncomment 
	/*
	@SuppressWarnings("rawtypes")
	@Override
	public DBServerInstanceResult getResult() {
		return null;
	}*/

}
