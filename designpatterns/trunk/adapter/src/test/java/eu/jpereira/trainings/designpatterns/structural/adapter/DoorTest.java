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

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.SimpleDoor;
/**
 * 
 * @author jpereira
 *
 */
public class DoorTest {

	@Test
	public void shouldOpenDoor() throws IncorrectDoorCodeException {
		Door door = createDoorUnderTest();
		door.open(getDefaultDoorCode());
		assertTrue(door.isOpen());
		
	}
	

	@Test(expected=IncorrectDoorCodeException.class)
	public void shouldThrowExceptionForWrongCode() throws IncorrectDoorCodeException {
		Door door = createDoorUnderTest();
		door.open("SomeHCode");
	}
	@Test
	public void shouldCloseDoor() throws IncorrectDoorCodeException {
		Door door = createDoorUnderTest();
		door.open(getDefaultDoorCode());
		assertTrue(door.isOpen());
		//close it
		door.close();
		assertFalse(door.isOpen());
	}
	
	@Test
	public void testChangeCode() throws IncorrectDoorCodeException, CodeMismatchException {
		Door door = createDoorUnderTest();
		door.changeCode(getDefaultDoorCode(), "123", "123");
		assertTrue(door.testCode("123"));
	}
	
	@Test(expected=IncorrectDoorCodeException.class)
	public void testThrowExceptionForIncorrectCodeChangingCode() throws IncorrectDoorCodeException, CodeMismatchException {
		Door door = createDoorUnderTest();
		door.changeCode("Dummy", "123", "123");
		
	}

	@Test(expected=CodeMismatchException.class)
	public void testThrowExceptionForMismatchNewCode() throws IncorrectDoorCodeException, CodeMismatchException {
		Door door = createDoorUnderTest();
		door.changeCode(getDefaultDoorCode(), "123", "1a23");
		
	}

	
	/**
	 * @return
	 */
	protected Door createDoorUnderTest() {
		// TODO Auto-generated method stub
		return new SimpleDoor();
	}
	

	/**
	 * @return
	 */
	protected String getDefaultDoorCode() {
		return SimpleDoor.DEFAULT_DOOR_CODE;
	}
}
