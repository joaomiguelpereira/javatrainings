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

import org.junit.Test;
import static org.junit.Assert.*;

import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CouldNotCloneLastObjectException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CannotHaveZeroPartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.NeedToPackLastVehicleException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.VehicleDoesNotHavePartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Shell;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Tire;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Vehicle;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Window;

/**
 * 
 * @author jpereira
 * 
 */
public class SimpleVehicleBuilderTest {

	
	@Test
	public void testCreateVehicle() throws NeedToPackLastVehicleException, VehicleDoesNotHavePartsException {

		SimpleVehicleBuilder builder = new SimpleVehicleBuilder();
		Vehicle vehicle = builder.createVehicle().packIt();
		assertEquals(0, vehicle.countParts());
	}
	@Test
	public void testTimesOne() throws NeedToPackLastVehicleException, VehicleDoesNotHavePartsException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
		SimpleVehicleBuilder builder = new SimpleVehicleBuilder();
		Vehicle vehicle = builder.createVehicle().with(new Tire()).times(1).packIt();
		assertEquals(1, vehicle.countParts());
		
	}
	@Test(expected=CannotHaveZeroPartsException.class)
	public void testTimesZero() throws NeedToPackLastVehicleException, VehicleDoesNotHavePartsException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
		SimpleVehicleBuilder builder = new SimpleVehicleBuilder();
		builder.createVehicle().with(new Tire()).times(0).packIt();
	}
	
	@Test
	public void testTimesMany() throws NeedToPackLastVehicleException, VehicleDoesNotHavePartsException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
		SimpleVehicleBuilder builder = new SimpleVehicleBuilder();
		Vehicle vehicle = builder.createVehicle().with(new Tire()).times(10).packIt();
		assertEquals(10, vehicle.countParts());		
	}
	
	@Test
	public void testTimesManyDifferent() throws NeedToPackLastVehicleException, VehicleDoesNotHavePartsException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
		SimpleVehicleBuilder builder = new SimpleVehicleBuilder();
		Vehicle vehicle = builder.createVehicle().with(new Tire()).times(10).with(new Window()).times(2).with(new Shell()).packIt();
		assertEquals(13, vehicle.countParts());
		
	}



}
