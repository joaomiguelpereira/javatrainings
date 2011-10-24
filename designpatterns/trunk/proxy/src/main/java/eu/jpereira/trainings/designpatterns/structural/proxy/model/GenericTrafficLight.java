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
package eu.jpereira.trainings.designpatterns.structural.proxy.model;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.LightsCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.PowerCommand;

/**
 * @author jpereira
 *
 */
public class GenericTrafficLight extends TrafficLight {

	/**
	 * @param ipAddress
	 */
	public GenericTrafficLight(String ipAddress) {
		super(ipAddress);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#getPowerOnCommand()
	 */
	@Override
	protected PowerCommand getPowerOnCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#getPowerOffCommand()
	 */
	@Override
	protected PowerCommand getPowerOffCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#getQueryPowerStatusCommand()
	 */
	@Override
	protected PowerCommand getQueryPowerStatusCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#getSetColorCommand(eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight.LightColors)
	 */
	@Override
	protected LightsCommand getSetColorCommand(LightColors color) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#createQueryColorCommand()
	 */
	@Override
	protected LightsCommand createQueryColorCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#createFlashingQueryCommand()
	 */
	@Override
	protected LightsCommand createFlashingQueryCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight#createSetFlashingCommand(boolean)
	 */
	@Override
	protected ControllerCommand createSetFlashingCommand(boolean flashing) {
		// TODO Auto-generated method stub
		return null;
	}

}
