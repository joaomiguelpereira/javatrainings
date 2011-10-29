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

import eu.jpereira.trainings.designpatterns.behavioral.command.model.DAO.DBServerInstanceGroupNotFoundException;

/**
 * If a The group with a given name could not be found
 * @author jpereira
 *
 */
public class GroupNotFoundException extends Exception {

	/**
	 * @param e
	 */
	public GroupNotFoundException(DBServerInstanceGroupNotFoundException e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7750841059091268638L;

}
