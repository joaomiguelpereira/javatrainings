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
package eu.jpereira.trainings.designpatterns.structural.proxy.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import eu.jpereira.trainings.designpatterns.structural.proxy.controller.exceptions.CouldNotConnectException;

/**
 * @author windows
 * 
 */
public class ProxyTrafficLightController extends TrafficLightController implements InvocationHandler {

	private int retries = 3; // Default value
	private long msBetweenRetries = 1000; // 1 second defaulr;

	private ITrafficLightController proxy;
	private ITrafficLightController realTrafficLightController;

	/**
	 * @param ipAddress
	 */
	public ProxyTrafficLightController(String ipAddress) {
		super(ipAddress);
		this.realTrafficLightController = createRealTrafficController();
		// Create the realTrafficLightController
		proxy = (ITrafficLightController) Proxy.newProxyInstance(this.realTrafficLightController.getClass().getClassLoader(), new Class[] { ITrafficLightController.class }, this);
		proxy.setIpAddress(this.realTrafficLightController.getIpAddress());

	}

	/**
	 * @return
	 */
	protected TrafficLightController createRealTrafficController() {
		return new GenericTrafficLightController(this.getIpAddress());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.controller.
	 * TrafficLightController
	 * #sendPowerCommand(eu.jpereira.trainings.designpatterns
	 * .structural.proxy.controller.ControllerCommand)
	 */
	@Override
	public void sendPowerCommand(ControllerCommand command) throws CouldNotConnectException {
		proxy.sendPowerCommand(command);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.proxy.controller.
	 * TrafficLightController
	 * #sendLightCommand(eu.jpereira.trainings.designpatterns
	 * .structural.proxy.controller.ControllerCommand)
	 */
	@Override
	public void sendLightCommand(ControllerCommand command) throws CouldNotConnectException {
		proxy.sendLightCommand(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Im proxy Invoking real object method");
		int failures = 0;
		boolean success = false;
		Exception lastExeption = null;
		Object result = null;
		while (!success) {

			try {
				result = method.invoke(realTrafficLightController, args);
				success = true;
			} catch (Exception e) {
				failures++;
				System.err.println("Retrying Failure: " + failures);
				lastExeption = e;
			}

			if (failures > retries) {
				throw new CouldNotConnectException(lastExeption);
			}
			//Wait
			Thread.currentThread().wait(this.msBetweenRetries);
		}
		return result;
	}

}
