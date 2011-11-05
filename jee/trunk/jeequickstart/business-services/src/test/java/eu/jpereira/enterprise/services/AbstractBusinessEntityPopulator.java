/**
 * Copyright [2011] [Joao Pereira - http://jpereira.eu]
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.enterprise.services;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * An AbstractBusinessEntity Populator
 * @author jpereira
 * 
 */
public abstract class AbstractBusinessEntityPopulator<T> {

	
	private SecureRandom secureRandom = new SecureRandom();
	
	/**
	 * Populate a BusinessEntity T
	 * @param entity The entity to poupualte
	 */
	protected abstract void populateBusinessEntity(T entity);
	
	
	/**
	 * Create a new populated instance of a BusinessEntity
	 * 
	 * @return An instance of BusinessEntity
	 * @throws Exception
	 *             If the instance cannot be instantiated
	 */
	public T createAndPopulateBusinessEntity() throws Exception {

		T instance = createEmptyBusinessEntity();
		populateBusinessEntity(instance);
		return (T) instance ;

	}


	/**
	 * Create a new emptyinstance of a BusinessEntity
	 * 
	 * @return An instance of BusinessEntity
	 * @throws Exception
	 *             If the instance cannot be instantiated
	 */

	@SuppressWarnings("unchecked")
	public T createEmptyBusinessEntity() throws Exception {

		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		// Create new instance
		@SuppressWarnings("rawtypes")
		Class<?> clazz = (Class) parameterizedType.getActualTypeArguments()[0];
		Object entity = clazz.newInstance();
		return (T) entity;

	}

	
	/**
	 * Create a unique string
	 * @return
	 */
	protected String createUniqueString() {

		return new BigInteger(132, secureRandom).toString(32);
	}

	


}
