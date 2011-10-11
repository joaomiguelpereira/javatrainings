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
package eu.jpereira.trainings.designpatterns.creational.builder.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jpereira
 * 
 */
public class SaleEntry {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public List<SoldItem> getSoldItems() {
		return soldItems;
	}

	private List<SoldItem> soldItems;

	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
		this.soldItems = new ArrayList<SoldItem>();
	}

	/**
	 * @param soldItem
	 */
	public void addSoldItem(SoldItem soldItem) {
		this.soldItems.add(soldItem);

	}

}
