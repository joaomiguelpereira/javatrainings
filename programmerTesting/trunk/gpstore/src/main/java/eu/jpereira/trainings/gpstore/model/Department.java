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

import eu.jpereira.trainings.gpstore.exceptions.NotImplementedException;
import eu.jpereira.trainings.gpstore.model.exceptions.DuplicateItemCategoryException;
import eu.jpereira.trainings.gpstore.model.exceptions.NoSuchItemCategoryException;

/**
 * This interface defines a general purpose Store's department
 * 
 * @author jpereira
 * 
 */
public class Department extends AbstractEntity {

	// data

	// constructors
	/**
	 * Public constructor
	 * 
	 * @see @See {@link AbstractEntity}
	 */
	public Department(long id) {
		super(id);

	}

	// operations

	/**
	 * Add a new ItemCategory to this department. This department can only sell
	 * SellableItems from the ItemCategories it owns
	 * 
	 * @param itemCategory
	 *            The new itemCategory
	 * 
	 * @throws DuplicateItemCategoryException
	 *             if the ItemCategory already exists
	 */
	public void addItemCategory(ItemCategory itemCategory) throws DuplicateItemCategoryException {
		throw new NotImplementedException();
	}

	/**
	 * Remove a category from this Department. This Department no longer sell
	 * items from this category.
	 * 
	 * @param id
	 *            The id of the ItemCategory
	 * @throws NoSuchItemCategoryException
	 *             If the category does not exists
	 */
	public void removeItemCategory(long id) throws NoSuchItemCategoryException {
		throw new NotImplementedException();
	}

	/**
	 * Returns a list o item categories.
	 * 
	 * @return the list of ItemCategory. If none exists, a empty list will be
	 *         returned.
	 */
	public List<ItemCategory> getAllItemCategories() {
		throw new NotImplementedException();
	}

	/**
	 * Find a ItemCategory by the name. This operation is <b>NOT</b> case
	 * sensitive
	 * 
	 * @param name
	 *            The name of expected ItemCategory
	 * @return The ItemCategory with the name equals to parameter name. If none
	 *         found, it gives you <b>null</b>
	 */
	public ItemCategory findItemCategoryByName(String name) {
		throw new NotImplementedException();
	}

	/**
	 * Get the number of ItemCategories that this department cas sell
	 * 
	 * @return The count of ItemCategories
	 */
	public int getItemCategoryCount() {
		throw new NotImplementedException();
	}

	/**
	 * Find a item category when you know its ID
	 * 
	 * @param id
	 *            the item category id
	 * @return A item category with the provided id, or null if no such item
	 *         category item
	 */
	public AbstractEntity findItemCategory(long id) {
		// TODO: Implement
		throw new NotImplementedException();
	}
}
