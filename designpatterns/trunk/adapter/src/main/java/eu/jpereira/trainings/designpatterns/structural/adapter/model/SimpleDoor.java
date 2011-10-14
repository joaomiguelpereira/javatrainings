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
public class SimpleDoor implements Door {

	public static String DEFAULT_DOOR_CODE = "AAFF1299BFA";

	private String code = DEFAULT_DOOR_CODE;

	private boolean open = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.model.DoorDriver
	 * #open(java.lang.String)
	 */
	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		// try the code
		if (this.code.equals(code)) {
			this.open = true;
		} else {
			throw new IncorrectDoorCodeException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.model.DoorDriver
	 * #close()
	 */
	@Override
	public void close() {
		this.open = false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.model.DoorDriver
	 * #isOpen()
	 */
	@Override
	public boolean isOpen() {
		return this.open;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.model.DoorDriver
	 * #changeCode(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {

		if (newCode.equals(newCodeConfirmation)) {
			if (oldCode.equals(this.code)) {
				this.code = newCode;
			} else {
				throw new IncorrectDoorCodeException();
			}
		} else {
			throw new CodeMismatchException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.adapter.model.DoorDriver
	 * #testCode(java.lang.String)
	 */
	@Override
	public boolean testCode(String code) {
		return code.equals(this.code);
	}

}
