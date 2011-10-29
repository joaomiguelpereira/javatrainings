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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.results.DBServerInstanceResult;

/**
 * @author jpereira
 *
 */
public class CommandJob implements Command{

	private List<Command> commands;
	
	public CommandJob() {
		this.commands = new ArrayList<Command>();
	}
	
	public void addCommand(Command command) {
		this.commands.add(command);
	}
	
	public Collection<Command> getCommands() {
		return Collections.unmodifiableCollection(commands);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.command.Command#execute()
	 */
	@Override
	public void execute() throws CouldNotConnectException {
		//for each command, execute it. 
		//Can store the result
		for (Command command : this.commands ) {
			command.execute();
		}
		
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.command.Command#getResult()
	 */
	@Override
	public DBServerInstanceResult getResult() {
		//Can store the result
		return null;
	}
	
}
