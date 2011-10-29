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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.results.DBServerInstanceResult;

/**
 * A CommandJob is a composite of {@link Command}
 * 
 * @author jpereira
 * 
 */

//TODO: EXERCISE implement Iterable<Command> and implement the method iterator()
public class CommandJob implements Command{

	private List<Command> commands;

	/**
	 * Create new Command Job
	 */
	public CommandJob() {
		this.commands = new ArrayList<Command>();
	}

	/**
	 * A a {@link Command} to the Job
	 * 
	 * @param command
	 *            the command
	 */
	public void addCommand(Command command) {
		this.commands.add(command);
	}

	/**
	 * Get an umodifiable collection of commands
	 * 
	 * @return
	 */
	public Collection<Command> getCommands() {
		return Collections.unmodifiableCollection(commands);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.command.model.command
	 * .Command#execute()
	 */

	@Override
	public void execute() throws CouldNotConnectException {
		// for each command, execute it.
		// Can store the result
		for (Command command : this.commands) {
			command.execute();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.command.model.command
	 * .Command#getResult()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DBServerInstanceResult getResult() {
		// Can store the result
		return null;
	}


}
