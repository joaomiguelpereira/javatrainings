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
package eu.jpereira.trainings.designpatterns.structural.adapter.model;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;

/**
 * @author jpereira
 * 
 */
public interface Door {

	

	/**
	 * Open the door if the code is correct
	 * 
	 * @param code
	 *            the code to open the door
	 * @throws IncorrectDoorCodeException
	 *             if the code is not correct
	 */
	void open(String code) throws IncorrectDoorCodeException;

	/**
	 * Attempt to close the door
	 */
	void close();

	/**
	 * Test if the door is open
	 * 
	 * @return
	 */
	boolean isOpen();

	/**
	 * Attempt to change the door code
	 * 
	 * @param oldCode
	 *            The old code
	 * @param newCode
	 *            the new code
	 * @param newCodeConfirmation
	 *            the new code confirmation
	 * @throws IncorrectDoorCodeException
	 */
	void changeCode(String oldCode, String newCode, String newCodeConfirmation)
			throws IncorrectDoorCodeException, CodeMismatchException;

	/**
	 * Test if a given code can open the door
	 * 
	 * @param code
	 *            the code to test
	 * @return true if the code can open the door, false otherwise
	 */
	boolean testCode(String code);

}
