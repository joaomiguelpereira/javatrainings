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
package eu.jpereira.trainings.designpatterns.behavioral.command.spies;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceProperties;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceStatus;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;

/**
 * @author jpereira
 *
 */
public class SpyDBServerInstance implements DBServerInstance {

	DBServerInstanceStatus status = DBServerInstanceStatus.UNKNOW;
	private String ipAddress;

	/**
	 * @param ipAddress
	 */
	public SpyDBServerInstance(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance#getIpAddress()
	 */
	@Override
	public String getIpAddress() {
		
		return this.ipAddress;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance#getConnectionDetails()
	 */
	@Override
	public DBServerInstanceProperties getConnectionDetails() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance#startInstance()
	 */
	@Override
	public void startInstance() throws CouldNotConnectException {
		this.status = DBServerInstanceStatus.STARTED;

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance#stopInstance()
	 */
	@Override
	public void stopInstance() throws CouldNotConnectException {
		this.status = DBServerInstanceStatus.STOPPED;

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance#getInstanceStatus()
	 */
	@Override
	public DBServerInstanceStatus getInstanceStatus() throws CouldNotConnectException {
		return status;
	}

}
