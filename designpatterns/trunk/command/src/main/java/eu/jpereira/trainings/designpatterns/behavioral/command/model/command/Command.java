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

import eu.jpereira.trainings.designpatterns.behavioral.command.model.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.results.DBServerInstanceResult;

/**
 * An abstraction of any command
 * 
 * @author jpereira
 * 
 */
public interface Command {

	/**
	 * Sends the request to receiver instance
	 * 
	 * @throws CouldNotConnectException
	 */
	void execute() throws CouldNotConnectException;

	/**
	 * Get the result of the command, if any.
	 * 
	 * @return <T extends {@link DBServerInstanceResult}> If this command produces any result, then it should be available
	 *         through this method. Null otherwise
	 */
	@SuppressWarnings("rawtypes")
	DBServerInstanceResult getResult();
}
