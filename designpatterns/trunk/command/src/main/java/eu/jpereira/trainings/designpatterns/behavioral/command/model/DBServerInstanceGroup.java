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

import java.util.Collection;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.NotUniqueDBInstanceException;

/**
 * This class represents a group of DB Server instances
 * 
 * @author jpereira
 * 
 */
public interface DBServerInstanceGroup {

	/**
	 * Get the unique name of this group
	 * @return the unique name of this group
	 */
	String getName();
	
	
	
	/**
	 * Adds an instance to the group.
	 * 
	 * @param instance
	 *            The instance to add to the group. The IPAddress of instance
	 *            should be unique whitin this group
	 * @throws NotUniqueDBInstanceException
	 *             if the IP Address of the instance is not unique
	 */
	void addInstance(DBServerInstance instance) throws NotUniqueDBInstanceException;

	/**
	 * Removes an instance from the groupe
	 * 
	 * @param ip
	 *            the ip of the instance to remove
	 * @return True when the instance was removed, false othwise (could be
	 *         because there's no instance with that ip)
	 */
	boolean removeInstance(String ip);

	/**
	 * Finds an instance of {@link DBServerInstance}
	 * 
	 * @param ipAddress
	 *            the IP Address of {@link DBServerInstance}
	 * @return a {@link DBServerInstance} or null if there's no instance with
	 *         that in in this group
	 */
	DBServerInstance getInstance(String ipAddress);
	
	/**
	 * Attempt to start all instances of this groups
	 * @throws CouldNotConnectException If any of the servers could not be reached
	 */
	void startAllInstances() throws CouldNotConnectException;
	
	
	/**
	 * Attempts to stop all instances of this group 
	 * @throws CouldNotConnectException
	 */
	void stopAllInstances() throws CouldNotConnectException;
	
	/**
	 * Get an unmodifieable list of instances
	 * @return
	 */
	Collection<DBServerInstance> getInstances();
	


	
}
