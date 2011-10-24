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
package eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions;

/**
 * @author jpereira
 *
 */
public class CouldNotConnectException extends Exception {

	/**
	 * @param e
	 */
	public CouldNotConnectException(CouldNotConnectException e) {
		super(e);
	}

	/**
	 * 
	 */
	public CouldNotConnectException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CouldNotConnectException(String message) {
		super(message);
	}

	/**
	 * @param exeption
	 */
	public CouldNotConnectException(Exception exeption) {
		super(exeption);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375441438135905097L;

}
