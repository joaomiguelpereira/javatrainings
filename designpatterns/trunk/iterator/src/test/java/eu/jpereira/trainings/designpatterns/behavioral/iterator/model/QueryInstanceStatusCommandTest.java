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
package eu.jpereira.trainings.designpatterns.behavioral.iterator.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.Command;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.QueryInstanceStatusCommand;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.results.DBServerInstanceResult;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.scheduler.CommandScheduler;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.commands.model.CommandFactory;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.commands.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.commands.model.DBServerInstanceStatus;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.service.ReferenceDBServerInstanceService;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.spies.SpyCommandScheduler;

/**
 * <b>Start up test.</b>
 * 
 * 
 * <ul>
 * <li>
 * In this file find, the TODOs and follow the instructions.</li>
 * <li>Next, create a new java interface called Command in
 * {@link eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model}
 * package</li>
 * <li>
 * Go to every class in
 * {@link eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model}
 * , find the TODos: and follow the instructions</li>
 * 
 * <li>Fix the Unit Testing framework. Open {@link SpyCommandScheduler} and
 * follow the TODOs</li>
 * <li>Create the Command Factory. Open {@link CommandFactory} and follow the
 * TODOs</li>
 * <li>Code the CommandScheduler. Open {@link CommandScheduler} and follow the
 * TODOs</li>
 * <li>Code the Service. Open {@link ReferenceDBServerInstanceService} and
 * follow TODOs</li>
 * </ul>
 * 
 * <p>
 * YOU'RE REQUIRED ONLY TO COMPLETE THE TODOS MARKED WITH <b>EXERCISE</b>
 * </p>
 * 
 * @author jpereira
 */

public class QueryInstanceStatusCommandTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testGetServerInstanceStatus() throws CouldNotConnectException {
		DBServerInstance instance = createMockedDBServerInstance();
		Command command = new QueryInstanceStatusCommand(instance);

		when(instance.getInstanceStatus()).thenReturn(DBServerInstanceStatus.UNKNOW);
		command.execute();

		DBServerInstanceResult<DBServerInstanceStatus> result = command.getResult();
		DBServerInstanceStatus status = result.getResult();

		assertEquals(DBServerInstanceStatus.UNKNOW, status);
	}

	/**
	 * @return
	 */
	private DBServerInstance createMockedDBServerInstance() {

		return mock(DBServerInstance.class);
	}

}
