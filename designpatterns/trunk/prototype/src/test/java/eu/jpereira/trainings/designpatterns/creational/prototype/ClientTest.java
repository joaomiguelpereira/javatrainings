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

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CannotHaveZeroPartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CouldNotCloneLastObjectException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.NeedToPackLastVehicleException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.VehicleDoesNotHavePartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Shell;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Tire;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Vehicle;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.VehiclePartEnumeration;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.VehiclePartPropertiesEnumeration;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.Window;
/**
 * @author jpereira
 *
 */

public class ClientTest {

	
	/**
	 * Integration Test
	 * @throws CouldNotCloneLastObjectException
	 * @throws CannotHaveZeroPartsException
	 * @throws NeedToPackLastVehicleException
	 * @throws VehicleDoesNotHavePartsException
	 */
	@Test
	public void testCreateBUS() throws CouldNotCloneLastObjectException, CannotHaveZeroPartsException, NeedToPackLastVehicleException, VehicleDoesNotHavePartsException {
		Client client = new Client();
		
		//create a bus car
		//Create props for tire
		Properties tiresProps = new Properties();
		tiresProps.put(VehiclePartPropertiesEnumeration.SIZE,10);

		//Create props for shell
		Properties shellProps = new Properties();
		shellProps.put(VehiclePartPropertiesEnumeration.COLOR,"blue");

		
		Properties windowProps = new Properties();
		windowProps.put(VehiclePartPropertiesEnumeration.WIDTH,20);
		windowProps.put(VehiclePartPropertiesEnumeration.WIDTH,20);

		//client.createVehicle().with(new Tires()).times(4).
		Vehicle vehicle = client.vehicleBuilder().createVehicle().with(new Tire(tiresProps)).times(3).with(new Window(windowProps)).times(8).with(new Shell(shellProps)).times(1).packIt();
		
		//Get all windows
		List<VehiclePart> parts = vehicle.getParts(VehiclePartEnumeration.WINDOW);
		assertEquals(8, parts.size());
		 
	}
}
