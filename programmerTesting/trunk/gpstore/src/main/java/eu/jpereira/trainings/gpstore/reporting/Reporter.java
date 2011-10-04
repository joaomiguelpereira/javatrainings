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
package eu.jpereira.trainings.gpstore.reporting;

import eu.jpereira.trainings.gpstore.model.AbstractEntity;

/**
 * This is the conctract for a a reporter. Each entity shoul be reported by an
 * reporter
 * 
 * @author jpereira
 * 
 */
public interface Reporter {

	/**
	 * Get all enities for the type associated with this reporter
	 * 
	 * The format we expect is JSON:
	 * 
	 * 
	 * {name: "storename" , id: storeId, departments[{name: "departmentname",
	 * id: departmentId, itemCategories: [{name:"itemCategoryName", id:
	 * itemCategoryName, saleableItems:{name: "saleableItemName", id:
	 * saleableItemId, description: "saleableItemDesctiprion", price:
	 * saleableItemPrice}]]}
	 * @param entity TODO
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @return
	 */
	public String getAsJSON(AbstractEntity entity);

	/**
	 * This allows the reporter to delegate to other reporters for a such kind
	 * of entity
	 * 
	 * @param childReporter
	 *            an instance of a reporter
	 * @param entityClazz
	 *            the class that will this report act upon
	 */
	public <T extends AbstractEntity> void addEntityReporter(Reporter childReporter, Class<T> entityClazz);

	/**
	 * Get the child reporter for the type represented by the argument
	 * 
	 * @param entityClazz
	 *            the type of the child reporter to look up
	 * @return the configured instance or null if none fouund
	 */
	public Reporter getEntityReporter(Class<?> entityClazz);

	
}
