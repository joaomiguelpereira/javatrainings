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
package eu.jpereira.trainings.designpatterns.behavioral.iterator.spies;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.Command;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.scheduler.CommandScheduler;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.scheduler.Schedule;

/**
 * @author jpereira
 * 
 */
public class SpyCommandScheduler implements CommandScheduler {

	private List<Command> scheduledCommand = new ArrayList<Command>();
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.scheduler.
	 * CommandScheduler
	 * #schedule(eu.jpereira.trainings.designpatterns.behavioral.
	 * command.model.command.Command,
	 * eu.jpereira.trainings.designpatterns.behavioral
	 * .command.scheduler.Schedule)
	 */	
	@Override
	public void schedule(Command command, Schedule schedule) {
		this.scheduledCommand.add(command);
		// Execute now
		try {
			command.execute();
		} catch (CouldNotConnectException e) {
			// In this fake, execution could not fail
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

}
