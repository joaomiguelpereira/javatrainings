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
package eu.jpereira.trainings.designpatterns.structural.facade.facade;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.fake.FakeCustomerNotificationService;

/**
 * @author jpereira
 * 
 */
public class AbstractClientTest {

	// Get the required services
	protected CustomerDBService customerService;
	protected BookDBService bookService;
	protected OrderingService orderingService;
	protected CustomerNotificationService customerNotificationService;
	protected WharehouseService warehouseService;

	@Before
	public void setupFakeServices() {
		// Get the required services
		// Use as a mock
		customerService = getMockedCustomerDBService();
		bookService = getMockedBookDBService();
		orderingService = getMockedOrderingService();
		customerNotificationService = getMockedCustomerNotificationService();
		warehouseService = getMockedWareHouseService();
	}

		/**
	 * Factory Method
	 * 
	 * @return
	 */
	protected CustomerDBService getMockedCustomerDBService() {
		return mock(CustomerDBService.class);
	}

	/**
	 * Factory Method
	 * 
	 * @return
	 */
	protected BookDBService getMockedBookDBService() {
		return mock(BookDBService.class);
	}

	/**
	 * Factory Method
	 * 
	 * @return
	 */
	protected OrderingService getMockedOrderingService() {
		return mock(OrderingService.class);
	}

	/**
	 * Factory method
	 * 
	 * @return
	 */
	protected CustomerNotificationService getMockedCustomerNotificationService() {
		return mock(CustomerNotificationService.class);
	}

	/**
	 * Factory method
	 * 
	 * @return
	 */
	protected WharehouseService getMockedWareHouseService() {
		return mock(WharehouseService.class);
	}

}
