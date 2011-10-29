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
package eu.jpereira.trainings.designpatterns.behavioral.command.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.command.fakes.FakeDBServerInstanceCommandFactory;
import eu.jpereira.trainings.designpatterns.behavioral.command.fakes.FakeInstanceGroupDAO;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.CommandFactory;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceStatus;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DAO.DBServerInstanceGroupDAO;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.scheduler.CommandScheduler;
import eu.jpereira.trainings.designpatterns.behavioral.command.scheduler.Schedule;
import eu.jpereira.trainings.designpatterns.behavioral.command.service.DBServerInstanceService;
import eu.jpereira.trainings.designpatterns.behavioral.command.service.ReferenceDBServerInstanceService;
import eu.jpereira.trainings.designpatterns.behavioral.command.service.GroupNotFoundException;
import eu.jpereira.trainings.designpatterns.behavioral.command.service.InstanceNotFoundException;
import eu.jpereira.trainings.designpatterns.behavioral.command.spies.SpyCommandScheduler;

/**
 * 
 * @author jpereira
 * 
 */
public class DBServerInstanceServiceTest {

	@Test
	public void testServerStatusUnknow() throws CouldNotConnectException, InstanceNotFoundException, GroupNotFoundException {
		// The SUT
		DBServerInstanceService service = createSeverInstanceService();
		// send a start command
		assertEquals(DBServerInstanceStatus.UNKNOW, service.getInstanceStatus("22.22.22.12", "moon"));
	}

	@Test
	public void testStartServerInstance() throws CouldNotConnectException, InstanceNotFoundException, GroupNotFoundException {
		// The SUT
		DBServerInstanceService service = createSeverInstanceService();
		// send a start command
		service.startInstance("22.22.22.12", "moon", getSchedule());
		assertEquals(DBServerInstanceStatus.STARTED, service.getInstanceStatus("22.22.22.12", "moon"));
	}

	@Test
	public void testStopServerInstance() throws CouldNotConnectException, InstanceNotFoundException, GroupNotFoundException {
		// The SUT
		DBServerInstanceService service = createSeverInstanceService();
		// send a start command
		service.startInstance("22.22.22.12", "moon", getSchedule());
		assertEquals(DBServerInstanceStatus.STARTED, service.getInstanceStatus("22.22.22.12", "moon"));

		service.stopInstance("22.22.22.12", "moon", getSchedule());

		assertEquals(DBServerInstanceStatus.STOPPED, service.getInstanceStatus("22.22.22.12", "moon"));

	}

	public void testAllInstancesUnknowStatus() throws CouldNotConnectException, GroupNotFoundException, InstanceNotFoundException {

		// The SUT
		DBServerInstanceService service = createSeverInstanceService();
		// All instance should be started
		assertEquals(DBServerInstanceStatus.UNKNOW, service.getInstanceStatus("22.22.22.12", "moon"));
		assertEquals(DBServerInstanceStatus.UNKNOW, service.getInstanceStatus("22.22.22.13", "moon"));
		assertEquals(DBServerInstanceStatus.UNKNOW, service.getInstanceStatus("22.22.22.14", "moon"));
	}

	@Test
	public void testStartAllInstances() throws CouldNotConnectException, InstanceNotFoundException, GroupNotFoundException {
		// The SUT
		DBServerInstanceService service = createSeverInstanceService();
		// send a start command
		service.startGroup("moon", getSchedule());

		// All instance should be started
		assertEquals(DBServerInstanceStatus.STARTED, service.getInstanceStatus("22.22.22.13", "moon"));
		assertEquals(DBServerInstanceStatus.STARTED, service.getInstanceStatus("22.22.22.14", "moon"));

	}
	
	@Test
	public void testStopAllInstances() throws CouldNotConnectException, InstanceNotFoundException, GroupNotFoundException {
		// The SUT
		DBServerInstanceService service = createSeverInstanceService();
		// send a start command
		service.stopGroup("moon", getSchedule());

		// All instance should be started
		assertEquals(DBServerInstanceStatus.STOPPED, service.getInstanceStatus("22.22.22.12", "moon"));
		assertEquals(DBServerInstanceStatus.STOPPED, service.getInstanceStatus("22.22.22.13", "moon"));
		assertEquals(DBServerInstanceStatus.STOPPED, service.getInstanceStatus("22.22.22.14", "moon"));

	}

	/**
	 * @return
	 */
	private Schedule getSchedule() {

		return new Schedule();
	}

	/**
	 * @return
	 */
	private DBServerInstanceService createSeverInstanceService() {
		DBServerInstanceGroupDAO serverInstanceGroupDAO = createInstanceGroupDao();
		CommandScheduler scheduler = createScheduler();
		CommandFactory commandFactory = createFactory();
		return new ReferenceDBServerInstanceService(serverInstanceGroupDAO, scheduler, commandFactory);
	}

	/**
	 * @return
	 */
	private CommandFactory createFactory() {
		return new FakeDBServerInstanceCommandFactory();
	}

	/**
	 * @return
	 */
	private CommandScheduler createScheduler() {
		return new SpyCommandScheduler();
	}

	/**
	 * @return
	 */
	private DBServerInstanceGroupDAO createInstanceGroupDao() {
		return new FakeInstanceGroupDAO();
	}
}
