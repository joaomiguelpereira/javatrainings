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
package eu.jpereira.trainings.gpstore.model;

/**
 * An abstraction of an entity in the application. 
 * 
 * @author jpereira
 * 
 */
public abstract class AbstractEntity {

	/**
	 * The immutable identifier of the entity.
	 */
	private long id;

	/**
	 * Every entity has a name.
	 */

	private String name;

	/**
	 * The Class can only be instantiated after it gets an ID.
	 * 
	 * @param id The given ID
	 */
	public AbstractEntity(long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
