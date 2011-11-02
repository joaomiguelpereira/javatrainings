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
package eu.jpereira.trainings.designpatterns.behavioral.state.command.director;

import eu.jpereira.trainings.designpatterns.behavioral.state.command.Command;

/**
 * Mediator of Commands execution
 * 
 * @author jpereira
 * 
 */
public interface CommandDirector {

	/**
	 * Set the strategy for when some command in the director fails to execute
	 * 
	 * @param stategy
	 */
	void setFailStrategy(FailStategy stategy);

	/**
	 * Will execute all commands according to the {@link FailStategy} set in
	 * {@link CommandDirector#setFailStrategy(FailStategy)}
	 * 
	 * @throws ErrorDirectingCommandsException
	 *             Encapsulates any error occurring in the process
	 */
	void run() throws ErrorDirectingCommandsException;

	/**
	 * Will add all commands to the list of commands to direct.
	 * If an command in undoable, them will try to rollback the command after command failure
	 * @param command A Command
	 * @param commands Array of commands. 
	 */
	void addCommand(Command command, Command...commands);
}
