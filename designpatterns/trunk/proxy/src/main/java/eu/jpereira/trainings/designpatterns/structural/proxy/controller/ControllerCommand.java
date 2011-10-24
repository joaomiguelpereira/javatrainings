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

import java.util.Properties;

/**
 * Abstraction of an TrafficLightController command
 * @author jpereira
 *
 */
public abstract class ControllerCommand {

	public static enum Type {
		GET, SET;
	}
	
	private String key;
	private String value;
	private Type type;
	
	private Properties responseProperties;
	
	public ControllerCommand() {
		this.responseProperties = new Properties();
	}

	/**
	 * If any, get the response sent from microcontroller, if any.
	 * Clients can look at the properties by key to see the values
	 * @return
	 */
	public  Properties getResponseProperties() {
		return this.responseProperties;
	}

	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
