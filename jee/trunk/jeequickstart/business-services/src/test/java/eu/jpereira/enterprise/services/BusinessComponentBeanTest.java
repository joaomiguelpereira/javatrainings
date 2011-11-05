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

import static org.mockito.Mockito.*;

import org.junit.Test;

import eu.jpereira.enterprise.model.BusinessEntity;

/**
 * Unit Tests for BusinessComponentBean
 * 
 * @author jpereira
 */
public class BusinessComponentBeanTest extends
		AbstractBusinessComponentTest<BusinessComponentBean> {

	BusinessEntityPopulator populator = new BusinessEntityPopulator();

	@Test
	public void testCreateBusinessEntity() throws Exception {

		// Create the SUT with an MockedEntityManager
		BusinessComponentBean sut = null;

		sut = createBusinessComponentInstanceUnderTest();
		sut.setEntityManager(emMock);
		// the zone to add
		// BusinessEntity dummyBusinessEntity = createDummyBusinessEntity();
		BusinessEntity dummyBusinessEntity = null;
		dummyBusinessEntity = populator.createAndPopulateBusinessEntity();
		// When we add a zone, the SUT will simple delegate that to the
		// EntityManager.persist
		sut.createBusinessEntity(dummyBusinessEntity);
		// Let's verify the behavior
		verify(emMock).persist(dummyBusinessEntity);
	}

	
}
