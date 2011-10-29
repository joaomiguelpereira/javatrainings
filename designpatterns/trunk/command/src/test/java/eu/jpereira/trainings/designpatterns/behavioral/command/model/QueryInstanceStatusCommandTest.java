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
package eu.jpereira.trainings.designpatterns.behavioral.command.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceStatus;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.Command;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.QueryInstanceStatusCommand;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.results.DBServerInstanceResult;
/**
 * @author jpereira
 *
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
		
		assertEquals(DBServerInstanceStatus.UNKNOW, status );
	}

	/**
	 * @return
	 */
	private DBServerInstance createMockedDBServerInstance() {
		
		return mock(DBServerInstance.class);
	}

}
