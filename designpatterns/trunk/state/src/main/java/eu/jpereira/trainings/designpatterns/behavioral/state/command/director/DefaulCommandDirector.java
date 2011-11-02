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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import eu.jpereira.trainings.designpatterns.behavioral.state.command.Command;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.CouldNotExecuteCommandException;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.CouldNotRollbackCommandException;
import eu.jpereira.trainings.designpatterns.behavioral.state.command.UndoableCommand;

/**
 * A default implemenatation of a {@link CommandDirector}
 * 
 * @author jpereira
 * 
 * 
 *         TODO: (DO IT LAST) Add method void addExceptionCommands(Class<?
 *         extends Throwable> exClass, Command...commands) to Interface
 *         {@link CommandDirector} and implement it. It's a map of exception
 *         classes to a list of commands that should run whenever an exception
 *         of the type exClass is thrown. Implement first a test for this method
 * 
 * 
 */

public class DefaulCommandDirector implements CommandDirector {

	// Fail Strategy. It will define how the DirectorrWill fail. Should it try
	// to recover, ignore, fail-fast?
	protected FailStategy failStrategy = null;
	// The commands to be executed by this director
	protected List<Command> commands = null;
	// Stack maintaining the commands already executed. Used for rollback
	// operations
	private Stack<Command> executedCommands;

	/**
	 * Create new DefaultCommandDirector
	 */
	public DefaulCommandDirector() {
		// Use DEFAULT. Will do a rollback after a first command execution
		// failure
		this.failStrategy = FailStategy.DEFAULT;
		// Delegate instantiation to a factory method
		this.commands = createCommands();
		// Delegate instantiation to a factory method
		this.executedCommands = createExecutedStack();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.mediator.appliance.director
	 * .CommandDirector#setFailStrategy(eu.jpereira.trainings.designpatterns.
	 * behavioral.mediator.appliance.director.FailStategy)
	 */

	@Override
	public void setFailStrategy(FailStategy strategy) {
		this.failStrategy = strategy;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.mediator.appliance.director
	 * .CommandDirector#run()
	 */

	@Override
	public void run() throws ErrorDirectingCommandsException {
		for (Command command : this.commands) {

			try { // Push the command to the stack of executed commands
				executedCommands.push(command);
				command.execute();

			} catch (CouldNotExecuteCommandException e) { // Default strategy is
															// to
				rollback();
				// Log
				e.printStackTrace();
				// abstract
				throw new ErrorDirectingCommandsException(e.fillInStackTrace());

			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.mediator.appliance.director
	 * .
	 * CommandDirector#addCommand(eu.jpereira.trainings.designpatterns.behavioral
	 * .mediator.command.Command,
	 * eu.jpereira.trainings.designpatterns.behavioral
	 * .mediator.command.Command[])
	 */

	@Override
	public void addCommand(Command command, Command... commands) {
		this.commands.add(command); // Add the Commands in the Arrsy of argument
									// commands to the list of commands to
									// execute
		if (commands != null && commands.length > 0) {
			this.commands.addAll(Arrays.asList(commands));
		}
	}

	/**
	 * Rollback the command execution
	 */
	private void rollback() {
		while (!executedCommands.isEmpty()) {
			// Pop the last executed command....
			Command rollBackcommand = executedCommands.pop();
			if (rollBackcommand instanceof UndoableCommand) {
				try {
					// Rollback it
					((UndoableCommand) rollBackcommand).rollback();
				} catch (CouldNotRollbackCommandException e) {
					// Ignore
					e.printStackTrace();
				}

			}
		}

	}

	/**
	 * Factory Method
	 * 
	 * @return
	 */
	protected Stack<Command> createExecutedStack() {
		return new Stack<Command>();
	}

	/**
	 * Factory method
	 * 
	 * @return
	 */
	protected List<Command> createCommands() {
		return new ArrayList<Command>();
	}

}
