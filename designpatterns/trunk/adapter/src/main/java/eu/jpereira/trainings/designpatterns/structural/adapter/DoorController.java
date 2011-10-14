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
package eu.jpereira.trainings.designpatterns.structural.adapter;

import eu.jpereira.trainings.designpatterns.structural.adapter.DoorNotManagedException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;

/**
 * @author jpereira
 *
 */
public interface DoorController {

	/**
	 * Add a controlled door
	 * @param targetDoor
	 */
	void addDoor(Door targetDoor);

	/**
	 * @param mocekedDoor
	 * @throws DoorNotManagedException 
	 * @throws IncorrectDoorCodeException 
	 */
	void openDoor(Door door, String doorCode) throws DoorNotManagedException, IncorrectDoorCodeException;
	
	void closeDoor(Door door) throws DoorNotManagedException;

	/**
	 * @return
	 */
	int countManagedDoors();

}
