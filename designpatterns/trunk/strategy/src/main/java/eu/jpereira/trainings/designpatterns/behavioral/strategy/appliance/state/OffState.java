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
package eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.state;

import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.communication.CommunicationStrategy;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.communication.ConnectionProperties;
import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.communication.Request;

/**
 * @author jpereira
 * 
 * TODO: Find the TODOs in this file and complete them
 *
 */
public class OffState extends AbstractApplianceStateBehavior {

	
	/**
	 * @param strategy
	 */
	public OffState(CommunicationStrategy strategy) {
		super(strategy);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#getState()
	 */
	@Override
	public ApplianceState getState() {
		
		return ApplianceState.OFF;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#start()
	 */
	@Override
	public ApplianceStateBehavior start() {
		//Do nothing, can't go to started when off. Must return the same state
		return this;
		
		
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#stop()
	 */
	@Override
	public ApplianceStateBehavior stop() {
		//Do nothing. Can't go from OFF to STOPPED
		return this;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#turnOn()
	 */
	@Override
	public ApplianceStateBehavior turnOn() {
		//Can go from OFF state (this) to ON state
		//Open the connection. Tests only
		this.communicationStategy.connect(new ConnectionProperties());
		this.communicationStategy.sendRequest(new Request());
		this.communicationStategy.disconnect();
		return ApplianceState.ON.getStateBehavior(this.communicationStategy);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#turnOff()
	 */
	@Override
	public ApplianceStateBehavior turnOff() {
		//Do nothing. It's already off
		return this;
	}

}
