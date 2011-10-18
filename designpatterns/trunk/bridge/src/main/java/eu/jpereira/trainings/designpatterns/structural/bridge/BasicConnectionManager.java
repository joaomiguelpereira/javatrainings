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
package eu.jpereira.trainings.designpatterns.structural.bridge;

import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ProtocolSelector;

/**
 * This is the Bridge to the different implementors of different protocols
 * There's a factory that creates the implementors based on best signal for each
 * of the protocols
 * 
 * @author jpereira
 * 
 */
public class BasicConnectionManager implements ConnectionManager {

	private ProtocolSelector protocolSelector;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.bridge.ConnectionManager
	 * #startConnection()
	 */
	@Override
	public void startConnection() {
		this.protocolSelector.selectGoodProtocol().startSession();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.bridge.ConnectionManager
	 * #setProtocolSelector
	 * (eu.jpereira.trainings.designpatterns.structural.bridge.ProtocolSelector)
	 */
	@Override
	public void setProtocolSelector(ProtocolSelector protocolSelector) {
		this.protocolSelector = protocolSelector;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.bridge.ConnectionManager
	 * #endConnection()
	 */
	@Override
	public void endConnection() {
		this.protocolSelector.selectGoodProtocol().endSession();

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.bridge.ConnectionManager#getUpTime()
	 */
	@Override
	public long getUpTime() {
		
		return this.protocolSelector.selectGoodProtocol().getUpTime();
	}

}
