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
package eu.jpereira.trainings.designpatterns.structural.proxy.fakes;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.ControllerCommand.Type;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.LightsCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.PowerCommand;
import eu.jpereira.trainings.designpatterns.structural.proxy.controller.TrafficLightController;
import eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight;
import eu.jpereira.trainings.designpatterns.structural.proxy.testconfig.TestConfiguration;

/**
 * @author jpereira
 * 
 */
public class FakeTrafficLight extends TrafficLight {

	/**
	 * @param ipAddress
	 */
	public FakeTrafficLight(String ipAddress) {
		super(ipAddress);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #createTrafficLightController()
	 */
	@Override
	protected TrafficLightController createDefaultTrafficLightController() {
		TrafficLightController controller = null;
		if (TestConfiguration.fakeFailuresInController ) {
			controller = new FakeFailureTrafficLightController(new FakeTrafficLightContoller(this.getIpAddress()));
		} else {
			controller = new FakeTrafficLightContoller(this.getIpAddress());
		}
		
		return controller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #getPowerCommand()
	 */
	@Override
	protected PowerCommand getPowerOnCommand() {
		return makeSetPowerCommand("powerStatus", "on");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #getPowerOffCommand()
	 */
	@Override
	protected PowerCommand getPowerOffCommand() {
		return makeSetPowerCommand("powerStatus", "off");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #getQueryPowerStatusCommand()
	 */
	@Override
	protected PowerCommand getQueryPowerStatusCommand() {
		return makeGetPowerCommand("powerStatus");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #getSetColorCommand
	 * (eu.jpereira.trainings.designpatterns.structural.proxy.
	 * model.TrafficLight.LightColors)
	 */
	@Override
	protected LightsCommand getSetColorCommand(LightColors color) {
		return makeSetLightCommand("color", color.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #createQueryColorCommand()
	 */
	@Override
	protected LightsCommand createQueryColorCommand() {
		return makeGetLightCommand("color");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #createFlashingQueryCommand()
	 */
	@Override
	protected LightsCommand createFlashingQueryCommand() {

		return makeGetLightCommand("flashing");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.structural.proxy.model.TrafficLight
	 * #createSetFlashingCommand(boolean)
	 */
	@Override
	protected ControllerCommand createSetFlashingCommand(boolean flashing) {
		return makeSetLightCommand("flashing", flashing?"1":"0");
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	private PowerCommand makeSetPowerCommand(String key, String value) {
		return makeSetCommand(key, value, new PowerCommand());

	}

	/**
	 * @param key
	 * @return
	 */
	private PowerCommand makeGetPowerCommand(String key) {
		return makeGetCommand(key, new PowerCommand());
	}

	private LightsCommand makeGetLightCommand(String key) {
		return makeGetCommand(key, new LightsCommand());
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	private LightsCommand makeSetLightCommand(String key, String value) {
		return makeSetCommand(key, value, new LightsCommand());
	}

	/**
	 * @param key
	 */
	private <T extends ControllerCommand> T makeSetCommand(String key, String value, T command) {
		command.setType(Type.SET);
		command.setKey(key);
		command.setValue(value);
		return command;
	}

	/**
	 * @param key
	 */
	private <T extends ControllerCommand> T makeGetCommand(String key, T command) {
		command.setType(Type.GET);
		command.setKey(key);
		return command;
	}

}
