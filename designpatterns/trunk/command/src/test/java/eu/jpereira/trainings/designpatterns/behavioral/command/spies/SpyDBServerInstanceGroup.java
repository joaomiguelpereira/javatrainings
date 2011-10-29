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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstance;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceGroup;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.NotUniqueDBInstanceException;

/**
 * @author jpereira
 * 
 */
public class SpyDBServerInstanceGroup implements DBServerInstanceGroup {

	private Map<String, DBServerInstance> instances = new HashMap<String, DBServerInstance>();

	private String name;

	/**
	 * @param name
	 */
	public SpyDBServerInstanceGroup(String name) {
		this.name = name;
		// Create dummy instances
		loadInstances();

	}

	/**
	 * 
	 */
	protected void loadInstances() {
		this.instances.put("22.22.22.12", new SpyDBServerInstance("22.22.22.12"));
		this.instances.put("22.22.22.13", new SpyDBServerInstance("22.22.22.13"));
		this.instances.put("22.22.22.14", new SpyDBServerInstance("22.22.22.14"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.
	 * DBServerInstanceGroup#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.
	 * DBServerInstanceGroup
	 * #addInstance(eu.jpereira.trainings.designpatterns.behavioral
	 * .command.model.DBServerInstance)
	 */
	@Override
	public void addInstance(DBServerInstance instance) throws NotUniqueDBInstanceException {
		this.instances.put(instance.getIpAddress(), instance);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.
	 * DBServerInstanceGroup#removeInstance(java.lang.String)
	 */
	@Override
	public boolean removeInstance(String ip) {

		return this.instances.remove(ip) != null ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.
	 * DBServerInstanceGroup#getInstance(java.lang.String)
	 */
	@Override
	public DBServerInstance getInstance(String ipAddress) {
		
		return this.instances.get(ipAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.
	 * DBServerInstanceGroup#startAllInstances()
	 */
	@Override
	public void startAllInstances() throws CouldNotConnectException {
		for (DBServerInstance instance : this.instances.values()) {
			instance.startInstance();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.behavioral.command.model.
	 * DBServerInstanceGroup#stopAllInstances()
	 */
	@Override
	public void stopAllInstances() throws CouldNotConnectException {
		for (DBServerInstance instance : this.instances.values()) {
			instance.stopInstance();
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Collection<DBServerInstance> getInstances() {
		return Collections.unmodifiableCollection(this.instances.values());
		
	}

}
