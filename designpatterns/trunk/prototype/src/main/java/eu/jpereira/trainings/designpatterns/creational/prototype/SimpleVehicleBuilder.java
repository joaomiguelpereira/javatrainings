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

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CouldNotCloneLastObjectException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CannotHaveZeroPartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.NeedToPackLastVehicleException;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Vehicle;

/**
 * @author jpereira
 *
 */
public class SimpleVehicleBuilder implements VehicleBuilder {

	private List<VehiclePart> vehicleParts;
	
	public SimpleVehicleBuilder() {
		this.vehicleParts = createNewPartsBag();
	}
	
	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.prototype.VehicleBuilder#createVehicle()
	 */
	@Override
	public VehicleBuilder createVehicle() throws NeedToPackLastVehicleException{
		//Just check this is allways the first call on the builder
		if (vehicleParts.size()!= 0) {
			throw new NeedToPackLastVehicleException();
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.prototype.VehicleBuilder#with(eu.jpereira.trainings.designpatterns.creational.prototype.VehiclePart)
	 */
	@Override
	public VehicleBuilder with(VehiclePart part) {
		this.vehicleParts.add(part);
		return this;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.prototype.VehicleBuilder#times(int)
	 */
	@Override
	public VehicleBuilder times(int times) throws CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
		if (times==0) {
			throw new CannotHaveZeroPartsException();
		}
		//get the last one and clone it xtimes 
		if ( this.vehicleParts.size()>0) {
			
			VehiclePart lastObject = this.vehicleParts.get(this.vehicleParts.size()-1);
			//add it xtimes
			for (int i=0; i< times-1; i++) {
				//new object
				try {
					this.vehicleParts.add((VehiclePart)lastObject.clone());
				} catch (CloneNotSupportedException e) {
					//Could not clone it. Wrap exception
					throw new CouldNotCloneLastObjectException(e);
				}
			}
		}
		return this;
		
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.prototype.VehicleBuilder#packIt()
	 */
	@Override
	public Vehicle packIt() {
		Vehicle vehicle = new Vehicle(); 
		vehicle.setParts(this.vehicleParts);
		//clear this reference for the chicle parts.
		this.vehicleParts = createNewPartsBag();
		return vehicle;
		
		
	}
	
	//Can be overriden by subclasses
	protected List<VehiclePart> createNewPartsBag() {
		return new ArrayList<VehiclePart>();
	}

}
