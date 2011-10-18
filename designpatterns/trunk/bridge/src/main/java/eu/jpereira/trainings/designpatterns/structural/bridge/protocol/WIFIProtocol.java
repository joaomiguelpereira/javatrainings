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
package eu.jpereira.trainings.designpatterns.structural.bridge.protocol;

/**
 * dummy implementation
 * 
 * @author jpereira
 * 
 */
public class WIFIProtocol extends Protocol {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.bridge.protocol.Protocol
	 * #startSession()
	 */
	@Override
	public void startSession() {
		// SOME HARD WORK

		super.setSessionActive(true);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.bridge.protocol.Protocol
	 * #endSession()
	 */
	@Override
	public void endSession() {
		// SOME HARD WORK

		super.setSessionActive(false);

	}

}
