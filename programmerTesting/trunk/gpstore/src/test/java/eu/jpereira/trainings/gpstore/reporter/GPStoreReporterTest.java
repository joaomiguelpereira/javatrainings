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
package eu.jpereira.trainings.gpstore.reporter;

import org.junit.Test;

import eu.jpereira.trainings.gpstore.model.Department;
import eu.jpereira.trainings.gpstore.model.GPStore;
import eu.jpereira.trainings.gpstore.model.exceptions.DuplicateDepartmentException;
import eu.jpereira.trainings.gpstore.reporting.GPStoreReporter;
import eu.jpereira.trainings.gpstore.reporting.Reporter;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * This test suite test the GPStoreReporter. SUT: GPStoreReporter Though the
 * code coverage for the SUT is 100%, we are not testing all scenarios. We have
 * tested a single store and a store with one department. The are other
 * scenarios to test.
 * <ul>
 * 
 * </li>With more than one department</li>
 * </ul>
 * TODO: Complete the test for all scenarios
 * The case for departments with ItemCategories will be tested in the
 * appropieted test
 * 
 * @author jpereira
 * 
 */
public class GPStoreReporterTest {

	@Test
	public void testGetAsStringForASingleStore() {

		// Create some dummy date
		GPStore store = new GPStore(10l);
		store.setName("Some dummy store");
		// create the reporter (sut)
		Reporter sut = new GPStoreReporter();
		String actualResult = sut.getAsJSON(store);
		// expected format is: {name: "Some dummy store", id: 10 }
		String expectedJSON = "{name: \"Some dummy store\", id: 10}";
		assertEquals(expectedJSON, actualResult);

	}

	@Test
	public void testGetAsStringForAStoreWithOneDepartment() throws DuplicateDepartmentException {

		// create mock for Department reported
		Reporter mockReporterForDepartment = mock(Reporter.class);
		// Create some dummy date
		GPStore store = new GPStore(10l);
		store.setName("Some dummy store");
		// Add a mocked department to the store

		Department department = mock(Department.class);

		// stubbed values
		when(department.getName()).thenReturn("Some dummy department");
		when(department.getId()).thenReturn(90L);

		store.addDepartment(department);

		// create the reporter (sut)
		Reporter sut = new GPStoreReporter();
		// Need a reporter for the department
		sut.addEntityReporter(mockReporterForDepartment, Department.class);

		// test behavior
		when(mockReporterForDepartment.getAsJSON(department)).thenReturn("{name: \"Some dummy department\", id: 90}");
		String actualResult = sut.getAsJSON(store);
		// expected format is: {name: "Some dummy store", id: 10 }
		String expectedJSON = "{name: \"Some dummy store\", id: 10, departments: [{name: \"Some dummy department\", id: 90}]}";
		assertEquals(expectedJSON, actualResult);

	}

}
