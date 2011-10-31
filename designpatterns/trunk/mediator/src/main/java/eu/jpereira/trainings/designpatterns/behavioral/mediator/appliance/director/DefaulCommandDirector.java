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
package eu.jpereira.trainings.designpatterns.behavioral.mediator.appliance.director;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import eu.jpereira.trainings.designpatterns.behavioral.mediator.command.Command;
import eu.jpereira.trainings.designpatterns.behavioral.mediator.command.CouldNotExecuteCommandException;
import eu.jpereira.trainings.designpatterns.behavioral.mediator.command.CouldNotRollbackCommandException;
import eu.jpereira.trainings.designpatterns.behavioral.mediator.command.UndoableCommand;

/**
 * @author jpereira
 * 
 */
public class DefaulCommandDirector implements CommandDirector {

	// Fail Startegy
	protected FailStategy failStrategy = null;
	protected List<Command> commands = null;
	private Stack<Command> executedCommands;

	/**
	 * Create new DefaultCommandDirector
	 */
	public DefaulCommandDirector() {
		this.failStrategy = FailStategy.DEFAULT;
		this.commands = createCommands();
		this.executedCommands = createExecutedStack();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.mediator.appliance.director
	 * .CommandDirector#setFailStrategy(eu.jpereira.trainings.designpatterns.
	 * behavioral.mediator.appliance.director.FailStategy)
	 */
	@Override
	public void setFailStrategy(FailStategy stategy) {
		this.failStrategy = stategy;

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

			try {
				executedCommands.push(command);
				command.execute();
			} catch (CouldNotExecuteCommandException e) {
				// Default strategy is to rollback

				rollback();
				// Log
				e.printStackTrace();
				// abstract
				throw new ErrorDirectingCommandsException(e.fillInStackTrace());

			}
		}

	}

	/**
	 * 
	 */
	private void rollback() {
		while (!executedCommands.isEmpty()) {

			Command rollBackcommand = executedCommands.pop();
			if (rollBackcommand instanceof UndoableCommand) {

				try {
					((UndoableCommand) rollBackcommand).rollback();
				} catch (CouldNotRollbackCommandException e) {
					// Ignore
					e.printStackTrace();
				}

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
		this.commands.add(command);
		this.commands.addAll(Arrays.asList(commands));
	}

}
