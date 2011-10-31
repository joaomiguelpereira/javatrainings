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
package eu.jpereira.trainings.designpatterns.behavioral.memento.appliance;

import eu.jpereira.trainings.designpatterns.behavioral.memento.appliance.snapshot.Snapshotable;

/**
 * 
 * @author jpereira
 * 
 */
public interface Appliance extends Snapshotable {

	/**
	 * Generic turnOn interface. Will turn on the Appliance to the AC Power This
	 * will turn the Appliance on
	 * 
	 * @throws ApplianceCommunicationExceptionIf
	 *             could not establish communication with the Appliance
	 */
	void turnOn() throws ApplianceCommunicationException;

	/**
	 * Generic Turn Off interface. Will turn off the Appliance from the AC Power
	 * Will turn the appliance OFF
	 * 
	 * @throws ApplianceCommunicationExceptionIf
	 *             could not establish communication with the Appliance
	 */
	void turnOff() throws ApplianceCommunicationException;

	/**
	 * Generic Start interface. Will start the function of the Appliance
	 * 
	 * @throws ApplianceCommunicationExceptionIf
	 *             could not establish communication with the Appliance
	 */
	void start() throws ApplianceCommunicationException;

	/**
	 * Generic Stop interface. Will stop the function of the Appliance
	 * 
	 * @throws ApplianceCommunicationExceptionIf
	 *             could not establish communication with the Appliance
	 */
	void stop() throws ApplianceCommunicationException;

}
