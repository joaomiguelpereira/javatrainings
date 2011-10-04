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
package eu.jpereira.trainings.gpstore.model;

/**
 * @author jpereira
 *
 */
public class SaleableItem extends AbstractEntity {

	
	//data
	/**
	 * The description of this saleableItem
	 */
	private String description;
	
	/**
	 * The price of this saleable item
	 */
	private float price;
	
	
	
	
	//State mutators
	/**
	 * @param id
	 * @see {@link AbstractEntity}
	 */ 
	public SaleableItem(long id) {
		super(id);	
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	//State getters
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	
	
}
