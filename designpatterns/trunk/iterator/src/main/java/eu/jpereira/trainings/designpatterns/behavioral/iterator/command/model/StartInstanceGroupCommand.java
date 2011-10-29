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
package eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.results.DBServerInstanceResult;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.commands.model.DBServerInstanceGroup;

/**
 * Encapsulates a start instance request group
 * @author jpereira
 *
 */
public class StartInstanceGroupCommand extends DBServerInstanceGroupCommand {

	/**
	 * Create a new instance of {@link StartInstanceGroupCommand}
	 * @param receiver the instance of {@link DBServerInstanceGroup} that will handle the request
	 */
	public StartInstanceGroupCommand(DBServerInstanceGroup receiver) {
		super(receiver);
	
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.command.DBServerInstanceGroupCommand#execute()
	 */	
	@Override
	public void execute() throws CouldNotConnectException {
		this.receiver.startAllInstances();

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.command.Command#getResult()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DBServerInstanceResult getResult() {
		return null;
	}

}
