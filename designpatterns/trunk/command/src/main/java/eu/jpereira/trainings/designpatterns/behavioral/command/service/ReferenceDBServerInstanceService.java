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

import eu.jpereira.trainings.designpatterns.behavioral.command.model.CommandFactory;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceGroup;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceStatus;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DAO.DBServerInstanceGroupDAO;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DAO.DBServerInstanceGroupNotFoundException;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.scheduler.CommandScheduler;
import eu.jpereira.trainings.designpatterns.behavioral.command.scheduler.Schedule;

/**
 * A Reference Implementation of a {@link DBServerInstanceService}
 * @author jpereira
 * 
 */
public class ReferenceDBServerInstanceService implements DBServerInstanceService {

	private DBServerInstanceGroupDAO serverInstanceGroupDAO;
	private CommandScheduler scheduler;
	private CommandFactory commandFactory;

	public ReferenceDBServerInstanceService(DBServerInstanceGroupDAO dao, CommandScheduler scheduler, CommandFactory commandFactory) {
		this.serverInstanceGroupDAO = dao;
		this.scheduler = scheduler;
		this.commandFactory = commandFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.service.
	 * DBServerInstanceService#startGroup(java.lang.String,
	 * eu.jpereira.trainings
	 * .designpatterns.behavioral.command.scheduler.Schedule)
	 */
	@Override
	public void startGroup(String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException {
		//TODO: EXERCISE: Uncomment implementation
		/*
		DBServerInstanceGroup group = findGroup(groupName);
		// Create a new JOB
		// TODO: IGNORE THIS IN THE EXERCISE: Move this to a job manager object
		CommandJob job = new CommandJob();
		for (DBServerInstance instance : group.getInstances()) {
			// The command
			
			Command startCommand = commandFactory.createStartCommand(instance);
			job.addCommand(startCommand);

		}
		this.scheduler.schedule(job, schedule);
	*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.service.
	 * DBServerInstanceService#stopGroup(java.lang.String,
	 * eu.jpereira.trainings.
	 * designpatterns.behavioral.command.scheduler.Schedule)
	 */
	@Override
	public void stopGroup(String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException {
		//TODO: EXERCISE: Uncomment implementation
		
		/*
		DBServerInstanceGroup group = findGroup(groupName);
		// Create a new JOB
		// TODO: IGNORE THIS IN THE EXERCISE: Move this to a job manager object		
		CommandJob job = new CommandJob();
		for (DBServerInstance instance : group.getInstances()) {
			// The command

			Command stopCommand = commandFactory.createStopCommand(instance);
			job.addCommand(stopCommand);

		}
		this.scheduler.schedule(job, schedule);
	*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.service.
	 * DBServerInstanceService#startInstance(java.lang.String, java.lang.String)
	 */
	@Override
	public void startInstance(String ipAddress, String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException, InstanceNotFoundException {
		//TODO: EXERCISE: Uncomment implementation
		/*
		// Create a command from a factory
		Command startCommand = commandFactory.createStartCommand(findInstance(ipAddress, groupName));
		// Send to scheduler
		scheduler.schedule(startCommand, schedule);
		*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.service.
	 * DBServerInstanceService#stoptInstance(java.lang.String, java.lang.String)
	 */
	@Override
	public void stopInstance(String ipAddress, String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException, InstanceNotFoundException {

		//TODO: EXERCISE: Uncomment implementation
		/*
		// Create a command from a factory
		Command startCommand = commandFactory.createStopCommand(findInstance(ipAddress, groupName));
		// Send to scheduler
		scheduler.schedule(startCommand, schedule);
	*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.service.
	 * DBServerInstanceService#getInstanceStatus(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public DBServerInstanceStatus getInstanceStatus(String ipAddress, String groupName) throws CouldNotConnectException, GroupNotFoundException, InstanceNotFoundException {
		//TODO: EXERCISE: Uncomment implementation
		/*
		// Create a command from a factory
		Command startCommand = commandFactory.createQueryInstanceStatusCommand(findInstance(ipAddress, groupName));

		// Execute sync, now
		startCommand.execute();
		// TODO: IGNORE THIS IN THE EXECISE: FIX the cast
		QueryInstanceStatusResult result = (QueryInstanceStatusResult) startCommand.getResult();
		return result.getResult();
		 */
		return null;
	}

	/**
	 * @param instance
	 * @param groupName
	 * @return
	 * @throws GroupNotFoundException
	 * @throws InstanceNotFoundException
	 */
	private DBServerInstance findInstance(String ipAddress, String groupName) throws GroupNotFoundException, InstanceNotFoundException {
		DBServerInstanceGroup group = null;
		// get the group
		// get the Group by the groupName

		try {
			group = serverInstanceGroupDAO.findByName(groupName);
		} catch (DBServerInstanceGroupNotFoundException e) {
			//Just Log
			e.printStackTrace();
			// throw encapsulated exception
			throw new GroupNotFoundException(e);
		}

		DBServerInstance instance = group.getInstance(ipAddress);

		if (instance == null) {
			throw new InstanceNotFoundException();
		}
		return instance;

	}

	/**
	 * @param groupName
	 * @return
	 * @throws GroupNotFoundException
	 */
	private DBServerInstanceGroup findGroup(String groupName) throws GroupNotFoundException {
		DBServerInstanceGroup group = null;
		// get the group
		// get the Group by the groupName

		try {
			group = serverInstanceGroupDAO.findByName(groupName);
		} catch (DBServerInstanceGroupNotFoundException e) {
			// Just Log
			e.printStackTrace();
			// throw encapsulated exception
			throw new GroupNotFoundException(e);
		}

		return group;

	}

}
