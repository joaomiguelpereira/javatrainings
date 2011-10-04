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

import java.util.List;

import eu.jpereira.trainings.gpstore.exceptions.DuplicateSaleableItemException;
import eu.jpereira.trainings.gpstore.exceptions.NotImplementedException;
import eu.jpereira.trainings.gpstore.model.exceptions.NoSuchSalealeItemExistsException;

/**
 * @author jpereira
 * 
 */
public class ItemCategory extends AbstractEntity {

	private String description;

	/**
	 * @param id
	 * @See {@link AbstractEntity}
	 */
	public ItemCategory(long id) {
		super(id);
	}

	/**
	 * Add a SaleableItem to this ItemCategory
	 * 
	 * @param saleableItem
	 *            The sellableItem
	 * @throws DuplicateSaleableItemException
	 *             If such a SaleableItem already exists in the collection of
	 *             saleable Items for this ItemCategory
	 */
	public void addSellableItem(SaleableItem saleableItem) throws DuplicateSaleableItemException {

	}

	/**
	 * Remove a sellableItem from this ItemCategory. Maybe it will be
	 * discontinued or moved to other category...
	 * 
	 * @param saleableItemId
	 *            The id of the saleable item
	 * @throws NoSuchSalealeItemExistsException
	 *             if the id does not represents any SaleableItem in this
	 *             ItemCategory
	 */
	public void removeSaleableItem(long saleableItemId) throws NoSuchSalealeItemExistsException {
		throw new NotImplementedException();
	}

	/**
	 * Returns a list o saleable items.
	 * 
	 * @return the list of SaleableItem. If none exists, a empty list will be
	 *         returned.
	 */
	public List<SaleableItem> getAllSaleableItems() {
		throw new NotImplementedException();
	}

	/**
	 * Find a SaleableItem by the name. This operation is <b>NOT</b> case
	 * sensitive
	 * 
	 * @param name
	 *            The name of expected SaleableItem
	 * @return The SaleAble with the name equals to parameter name. If none
	 *         found, it gives you <b>null</b>
	 */
	public SaleableItem findSaleableItemByName(String name) {
		throw new NotImplementedException();
	}

	/**
	 * Get the number of SaleableItems that this ItemCategory groups
	 * 
	 * @return The count of SaleableItems
	 */
	public int getSaleableItemCount() {
		throw new NotImplementedException();
	}

	/**
	 * Find a saleable item when you know its ID
	 * 
	 * @param id
	 *            the saleableItemId
	 * @return A saleable item with the provided id, or null if no such saleable
	 *         item exists
	 */
	public SaleableItem findSaleableItem(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
