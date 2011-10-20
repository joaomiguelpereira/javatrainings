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
package eu.jpereira.trainings.designpatterns.structural.facade.client;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.fake.FakeCustomerNotificationService;
import static org.junit.Assert.*;
/**
 * An integration test
 * 
 * @author jpereira
 * 
 */
public class ClientIntegrationTest extends AbstractIntegrationTest {



	

	@Test
	public void testPlaceOrder() {
		// Have customer id and ISBN
		String customerId = "wall-e";
		String isbn = "1234567890";

		// Get the customer
		Customer customer = customerService.findCustomerById(customerId);
		// Get the book
		Book book = bookService.findBookByISBN(isbn);
		// Place order
		Order order = orderingService.createOrder(customer, book);
		// Notify customer. Order placed
		customerNotificationService.notifyClient(order);
		// Dispatch order
		DispatchReceipt dispatchReceipt = warehouseService.dispatch(order);
		// notify customer. Order dispatched
		customerNotificationService.notifyClient(dispatchReceipt);
		
		
	}


	

}
