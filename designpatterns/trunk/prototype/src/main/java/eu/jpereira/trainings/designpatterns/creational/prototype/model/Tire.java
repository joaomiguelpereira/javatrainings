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
package eu.jpereira.trainings.designpatterns.creational.prototype.model;

import java.util.Properties;

import eu.jpereira.trainings.designpatterns.creational.prototype.VehiclePart;

/**
 * @author jpereira
 *
 */
public class Tire extends AbstractVehiclePart {
	/**
	 * @param string
	 */
	public Tire(Properties properties) {
		super(properties);
	}

	/**
	 * 
	 */
	public Tire() {
		//Create default props
		super(new Properties());
	}

	@Override
	public VehiclePart clone() throws CloneNotSupportedException  {
		return (VehiclePart)super.clone();
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.prototype.VehiclePart#is(eu.jpereira.trainings.designpatterns.creational.prototype.model.VehiclePartEnumeration)
	 */
	@Override
	public boolean is(VehiclePartEnumeration type) {
		
		return VehiclePartEnumeration.TIRE.equals(type);
	}
}
