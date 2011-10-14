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

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.structural.adapter.DoorNotManagedException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;

/**
 * @author jpereira
 * 
 */
public class SimpleDoorController implements DoorController {

	private List<Door> managedDoors;

	public SimpleDoorController() {
		this.managedDoors = createManagedDoorsComposite();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.DoorController
	 * #addDoor
	 * (eu.jpereira.trainings.designpatterns.structural.adapter.model.Door)
	 */
	@Override
	public void addDoor(Door managedDoor) {
		if ( !this.managedDoors.contains(managedDoor)) {
			this.managedDoors.add(managedDoor);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.DoorController
	 * #openDoor
	 * (eu.jpereira.trainings.designpatterns.structural.adapter.model.Door)
	 */
	@Override
	public void openDoor(Door door, String doorCode) throws DoorNotManagedException, IncorrectDoorCodeException{
		getDoor(door).open(doorCode);
		
	}

	/**
	 * FActory method
	 * 
	 * @return
	 */
	protected List<Door> createManagedDoorsComposite() {
		
		return new ArrayList<Door>();
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.adapter.DoorController#countManagedDoors()
	 */
	@Override
	public int countManagedDoors() {
		return this.managedDoors.size();
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.adapter.DoorController#closeDoor(eu.jpereira.trainings.designpatterns.structural.adapter.model.Door)
	 */
	@Override
	public void closeDoor(Door door) throws DoorNotManagedException {
		getDoor(door).close();
		
	}

	
	private Door getDoor(Door door) throws DoorNotManagedException {
		if ( this.managedDoors.contains(door)) {
			return this.managedDoors.get(this.managedDoors.indexOf(door));
		} else {
			throw new DoorNotManagedException();
		}		
	}
}
