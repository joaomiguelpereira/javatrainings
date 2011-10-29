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

import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;

/**
 * 
 * This class models a Database Server instance running on a network node. A
 * given instante is identified by the IP Address of the node where the instance
 * is running
 * 
 * @author jpereira
 * 
 */
public interface DBServerInstance {

	/***
	 * Return the IP Address of the node where the instance is running.
	 * The IP Address value should be unique in the context of a {@link DBServerInstanceGroup}
	 * DB
	 * @return The IP Address
	 */
	String getIpAddress();

	
	/**
	 * Get the properties associated to the current instance
	 * 
	 * @return an instance of DBServerInstanceProperties or null if none
	 *         associated
	 */

	DBServerInstanceProperties getConnectionDetails();

	/**
	 * Starts the instance.
	 * 
	 * @throws CouldNotConnectException
	 *             if some error occurs while connecting to the instance
	 */
	void startInstance() throws CouldNotConnectException;

	/**
	 * Attempts to stop an instance
	 * 
	 * @throws CouldNotConnectException
	 *             if some exception in the normal flow occurs
	 */
	void stopInstance() throws CouldNotConnectException;
	
	/**
	 * Get the current instance status
	 * @return
	 * @throws CouldNotConnectException instance status
	 * @see DBServerInstanceStatus
	 */
	DBServerInstanceStatus getInstanceStatus() throws CouldNotConnectException;
	

}
