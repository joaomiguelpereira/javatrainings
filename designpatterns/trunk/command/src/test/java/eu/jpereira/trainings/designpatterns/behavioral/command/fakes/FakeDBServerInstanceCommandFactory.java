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
package eu.jpereira.trainings.designpatterns.behavioral.command.fakes;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.CommandFactory;


/**
 * @author jpereira
 *
 */
public class FakeDBServerInstanceCommandFactory implements CommandFactory {

	
	
	//TODO: EXERCISE: Uncomment implementation
	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.CommandFactory#createStartCommand()
	 */
	/*
	@Override
	public Command createStartCommand(DBServerInstance receiver) {
		
		return new StartInstanceCommand(receiver);
	}*/

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.CommandFactory#createStopCommand(eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance)
	 */
	//TODO: EXERCISE: Uncomment implementation
	/*
	@Override
	public Command createStopCommand(DBServerInstance receiver) {
		
		return new StopInstanceCommand(receiver);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.CommandFactory#createQueryInstanceStatusCommand(eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance)
	 */
	
	//TODO: EXERCISE: Uncomment implementation
	/*@Override
	public Command createQueryInstanceStatusCommand(DBServerInstance receiver) {
		
		return new QueryInstanceStatusCommand(receiver);
	}*/

}
