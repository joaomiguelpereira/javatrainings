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
package eu.jpereira.trainings.designpatterns.behavioral.state.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Composite of {@link Command}
 * 
 * @author jpereira
 * 
 */
public class Event implements UndoableCommand, Iterable<Command> {

	// Back list
	private List<Command> commands;

	private Stack<Command> executedCommands;

	public Event() {
		this.commands = createCommandList();
		this.executedCommands = createSucceedCommand();
	}

	/**
	 * Adds a new command to be executed in this event's execute()
	 * 
	 * @param command
	 */
	public void addCommand(Command command) {
		this.commands.add(command);
	}

	public void removeCommand(Command command) {
		this.commands.remove(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.mediator.command.Command
	 * #execute()
	 */
	@Override
	public void execute() throws CouldNotExecuteCommandException {
		for (Command command : commands) {
			this.executedCommands.push(command);
			command.execute();
			

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Command> iterator() {
		return this.commands.iterator();
	};

	/**
	 * Create the list of commands
	 * 
	 * @return
	 */
	protected List<Command> createCommandList() {
		return new ArrayList<Command>();
	}

	/**
	 * Factory method
	 * 
	 * @return
	 */
	protected Stack<Command> createSucceedCommand() {

		return new Stack<Command>();
	}

	/**
	 * @param command
	 *            an array of commands
	 * @return
	 */
	public Event with(Command... command) {

		this.commands.addAll(Arrays.asList(command));
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.mediator.command.
	 * UndoableCommand#rollback()
	 */
	@Override
	public void rollback() throws CouldNotRollbackCommandException {
		while ( !executedCommands.isEmpty()) {
			Command command = executedCommands.pop();
			if (command instanceof UndoableCommand) {
				((UndoableCommand)(command)).rollback();
			}
		}

	}

}
