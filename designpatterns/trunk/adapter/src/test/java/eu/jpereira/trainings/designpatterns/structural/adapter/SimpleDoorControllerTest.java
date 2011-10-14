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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.SimpleDoor;

/**
 * @author jpereira
 * 
 */
public class SimpleDoorControllerTest {

	@Test(expected = DoorNotManagedException.class)
	public void testShouldThrowExceptionForInexistentDoor() throws DoorNotManagedException, IncorrectDoorCodeException {
		// Create a simple dummy door, conforming the Interface Door
		Door aDoor = createMockedDoor();

		// Add this door to the controller
		DoorController controller = createDoorControllerUnderTest();
		// do not add the door. Is expected an exception;
		// can use any code, it's outside of test scope here
		controller.openDoor(aDoor, getDefaultCodeForDoor());
	}

	@Test
	public void testShouldNotAddSameElement() {
		// Create a simple dummy door, conforming the Interface Door
		Door mockedDoor = createMockedDoor();
		DoorController controller = createDoorControllerUnderTest();
		controller.addDoor(mockedDoor);

		assertEquals(1, controller.countManagedDoors());
		controller.addDoor(mockedDoor);
		assertEquals(1, controller.countManagedDoors());
	}

	@Test
	public void testShouldOpenDoor() throws DoorNotManagedException, IncorrectDoorCodeException {
		// Create a simple dummy door, conforming the Interface Door
		Door door = createMockedDoor();
		// Add this door to the controller
		DoorController controller = createDoorControllerUnderTest();
		controller.addDoor(door);
		// can use any code, it's outside of test scope here
		controller.openDoor(door, getDefaultCodeForDoor());
		// ensure that the door open() was called in the targetDoor
		verify(door).open(getDefaultCodeForDoor());

	}

	@Test
	public void testShouldCloseDoor() throws DoorNotManagedException, IncorrectDoorCodeException {
		Door mockedDoor = createMockedDoor();
		DoorController controller = createDoorControllerUnderTest();
		// Add the door to the controller
		controller.addDoor(mockedDoor);
		// Open the door
		controller.openDoor(mockedDoor, getDefaultCodeForDoor());
		verify(mockedDoor).open(getDefaultCodeForDoor());
		controller.closeDoor(mockedDoor);
		verify(mockedDoor).close();

	}

	@Test(expected = DoorNotManagedException.class)
	public void testShouldThrowExceptionClosingNotManagedDoor() throws DoorNotManagedException, IncorrectDoorCodeException {
		Door mockedDoor = createMockedDoor();
		DoorController controller = createDoorControllerUnderTest();
		// dont add the door to the controller
		controller.closeDoor(mockedDoor);

	}

	/**
	 * Factory method for the door controller
	 * 
	 * @return
	 */
	protected DoorController createDoorControllerUnderTest() {
		return new SimpleDoorController();
	}

	/**
	 * @return
	 */
	protected String getDefaultCodeForDoor() {
		return SimpleDoor.DEFAULT_DOOR_CODE;

	}

	/**
	 * Factory method for test door
	 * 
	 * @return
	 */
	protected Door createMockedDoor() {
		return mock(Door.class);

	}
}
