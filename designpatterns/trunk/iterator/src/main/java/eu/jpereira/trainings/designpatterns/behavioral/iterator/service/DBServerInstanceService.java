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
package eu.jpereira.trainings.designpatterns.behavioral.iterator.service;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.scheduler.Schedule;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.commands.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.commands.model.DBServerInstanceStatus;

/**
 * This service defines the interfaces clients can use to manage
 * {@link DBServerInstance}
 * 
 * @author jpereira
 * 
 */
public interface DBServerInstanceService {

	/**
	 * Start an {@link DBServerInstance}
	 * 
	 * @param ipAddress
	 *            the IP of the {@link DBServerInstance}
	 * @param groupName The Group Name that has the {@link DBServerInstance}
	 * @param schedule The Schedule
	 * @throws CouldNotConnectException
	 *             If some error occurs while connecting to the
	 *             {@link DBServerInstance}
	 * @throws InstanceNotFoundException 
	 * @throws GroupNotFoundException 
	 */
	void startInstance(String ipAddress, String groupName, Schedule schedule) throws CouldNotConnectException, InstanceNotFoundException, GroupNotFoundException;

	/**
	 * Stop an {@link DBServerInstance}
	 * 
	 * @param ipAddress
	 *            the IP of the {@link DBServerInstance}
	 * @param groupName The Group Name that has the {@link DBServerInstance}
	 * @param schedule The Schedule
	 * @throws CouldNotConnectException
	 *             If some error occurs while connecting to the
	 *             {@link DBServerInstance}
	 * @throws GroupNotFoundException If no group exists with that name
	 * @throws InstanceNotFoundException If the instance could not be found
	 */
	void stopInstance(String ipAddress, String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException, InstanceNotFoundException;

	/**
	 * Get the status of an {@link DBServerInstance}
	 * 
	 * @param ipAddress
	 *            the IP address of the {@link DBServerInstance} being queried
	 * @param groupName The Group Name that has the {@link DBServerInstance}
	 * @return The {@link DBServerInstanceStatus} of the instance
	 * @throws CouldNotConnectException
	 *             If some error occurs while connecting to the
	 *             {@link DBServerInstance}
	 * @throws GroupNotFoundException If the goups could not be found
	 * @throws InstanceNotFoundException if the Instance could not be found
	 *             
	 */
	DBServerInstanceStatus getInstanceStatus(String ipAddress, String groupName) throws CouldNotConnectException, GroupNotFoundException, InstanceNotFoundException;

	/**
	 * Starts a group of instances
	 * 
	 * @param groupName
	 *            The name of the group
	 * @param schedule 
	 * @throws CouldNotConnectException
	 *             If some error occurs while connection to one of the instances
	 *             in the group
	 * @throws GroupNotFoundException If the Group could not be found
	 */
	void startGroup(String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException;

	/**
	 * Stops a group of instances
	 * 
	 * @param groupName
	 *            The name of the group
	 * @param schedule 
	 * @throws CouldNotConnectException
	 *             If some error occurs while connection to one of the instances
	 *             in the group
	 * @throws GroupNotFoundException If the Group could not be found
	 */

	void stopGroup(String groupName, Schedule schedule) throws CouldNotConnectException, GroupNotFoundException;

}
