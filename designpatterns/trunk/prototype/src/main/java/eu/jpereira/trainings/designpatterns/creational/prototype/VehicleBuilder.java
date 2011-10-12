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
package eu.jpereira.trainings.designpatterns.creational.prototype;

import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CouldNotCloneLastObjectException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CannotHaveZeroPartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.NeedToPackLastVehicleException;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Vehicle;

/**
 * @author jpereira
 *
 */
public interface VehicleBuilder {

	/**
	 * @return
	 * @throws NeedToPackLastVehicleException 
	 */
	VehicleBuilder createVehicle() throws NeedToPackLastVehicleException;

	/**
	 * @param tire
	 * @return
	 */
	VehicleBuilder  with(VehiclePart part);

	/**
	 * @param i
	 * @return
	 */
	VehicleBuilder times(int i) throws CouldNotCloneLastObjectException, CannotHaveZeroPartsException;

	/**
	 * 
	 */
	Vehicle packIt();

}
