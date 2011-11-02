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

/**
 * @author windows
 *
 */
public class StoppedState extends AbstractApplianceStateBehavior {

	/**
	 * @param strategy
	 */
	public StoppedState(CommunicationStrategy strategy) {
		super(strategy);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#getState()
	 */
	@Override
	public ApplianceState getState() {
		return ApplianceState.STOPPED;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#start()
	 */
	@Override
	public ApplianceStateBehavior start() {
		//Can start
		return ApplianceState.STARTED.getStateBehavior(this.communicationStategy);
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#stop()
	 */
	@Override
	public ApplianceStateBehavior stop() {
		// Already stopped
		return this;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#turnOn()
	 */
	@Override
	public ApplianceStateBehavior turnOn() {
		//It's started, so turned on
		return this;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state.ApplianceStateBehavior#turnOff()
	 */
	@Override
	public ApplianceStateBehavior turnOff() {
		// After stopped, can go off
		return ApplianceState.OFF.getStateBehavior(this.communicationStategy);
	}

}
