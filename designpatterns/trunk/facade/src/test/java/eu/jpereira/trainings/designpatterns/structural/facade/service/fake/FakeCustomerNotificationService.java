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
package eu.jpereira.trainings.designpatterns.structural.facade.service.fake;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;

/**
 * @author jpereira
 *
 */
public class FakeCustomerNotificationService implements CustomerNotificationService {

	
	private List<Order> notifiedOrders = new ArrayList<Order>();
	private List<DispatchReceipt> notifiedDispatchReceipts = new ArrayList<DispatchReceipt>();
	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService#notifyClient(eu.jpereira.trainings.designpatterns.structural.facade.model.Order)
	 */
	@Override
	public void notifyClient(Order order) {
		this.notifiedOrders.add(order);
		
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService#notifyClient(eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt)
	 */
	@Override
	public void notifyClient(DispatchReceipt dispatchReceipt) {
		notifiedDispatchReceipts.add(dispatchReceipt);
		
	}
	
	//Spy
	public List<Order> getNotifiedOrders() {
		return this.notifiedOrders;
	}
	
	public List<DispatchReceipt> getNotifiedDisptachReceipts() {
		return this.notifiedDispatchReceipts;
	}

}
