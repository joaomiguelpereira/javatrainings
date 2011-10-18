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
 * @author jpereira
 * 
 */
public abstract class Protocol {

	// Some variable keeping the up time of this protocol
	private long upTime = 0;
	// Flag is session is active
	private boolean sessionActive = false;

	/**
	 * Start a session
	 */
	public abstract void startSession();

	/**
	 * End a session
	 */
	public abstract void endSession();

	/**
	 * @return the uptime
	 */
	public long getUpTime() {
		return this.upTime;
	}

	/**
	 * Test if the session is active
	 * 
	 * @return true if yes, false otherwise
	 */
	public boolean isSessionActive() {
		return this.sessionActive;
	}

	/**
	 * Change the state of active session
	 * 
	 * @param active
	 */
	protected void setSessionActive(boolean active) {
		this.sessionActive = active;
	}
}
