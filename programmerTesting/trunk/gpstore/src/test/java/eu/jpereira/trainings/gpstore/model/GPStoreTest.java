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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.trainings.gpstore.model.Department;
import eu.jpereira.trainings.gpstore.model.GPStore;
import eu.jpereira.trainings.gpstore.model.exceptions.DuplicateDepartmentException;
import eu.jpereira.trainings.gpstore.model.exceptions.NoSuchDepartmentException;

/**
 * This is a test suite for Unit Testing the object GPStore thus, the System
 * Under Test is GPStore
 * 
 * @author jpereira
 * 
 */
public class GPStoreTest {

	// this TestSuite can be extended.
	protected GPStore sut;

	@Before
	public void setup() {
		// HINT: Create from a factory
		// Using magic number, but will factor this into a factory
		this.sut = new GPStore(19l);
	}

	@Test
	public void testAddDepartment() {
		// HINT: Create from a factory
		// Using magic number, but will be factored into a factory
		// Creating dummy object
		Department dummyDepartment = new Department(10l);
		// try to add
		try {
			sut.addDepartment(dummyDepartment);
		} catch (DuplicateDepartmentException e) {
			//If this exception is thrown, the something is going wrong
			fail(e.getMessage());
			e.printStackTrace();
		}
		// correctly added?
		// Here we are also testing the getDepartmentCount method 
		assertEquals(1, sut.getDepartmentCount());
	}

	@Test(expected = DuplicateDepartmentException.class)
	public void testAddDuplicateDepartment() throws DuplicateDepartmentException {

		// HINT: Create from a factory
		// Using magic number, but will be factored into a factory
		// create first dummy object
		Department dummyDepartment = new Department(10l);
		// create a second dummy object with the same id
		Department sameDummyDepartment = new Department(10l);

		// From a business point of view, they are the same because they have
		// the same identity

		// Add first dummy
		sut.addDepartment(dummyDepartment);
		// add second dummy. Should throw an DuplicateDepartmentException, as expected in the @Test declaration
		sut.addDepartment(sameDummyDepartment);

	}

	@Test
	public void testRemoveDepartment() {
		// Create some dummy department
		Department dummyDepartment = new Department(10l);
		// add it to the sut
		try {
			sut.addDepartment(dummyDepartment);
		} catch (DuplicateDepartmentException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		// verify it was added, double check ;)
		assertEquals(1, sut.getDepartmentCount());
		// test now that it will be removed
		try {
			// move magic number somewhere else
			sut.removeDepartment(10l);
		} catch (NoSuchDepartmentException e) {
			// don't rely only with this check. The type of exception can be
			// some runtime one
			fail(e.getMessage());
			e.printStackTrace();
		}
		// assert it was removed
		assertEquals(0, sut.getDepartmentCount());
	}

	@Test(expected = NoSuchDepartmentException.class)
	public void tetRemoveNoSuchDepartment() throws NoSuchDepartmentException {
		sut.removeDepartment(10l);
	}

	// TODO: Complete the following tests and add more to reach 100% line
	// coverage and 100% branch coverage in class GPStore

	@Test
	public void testFindDepartmentByName() {
		// TODO: Implement test
		fail("Test not implemented");
	}

	@Test
	public void testFindDepartmentByNameWhenNameDoesNotExists() {
		// TODO: Implement test
		fail("Test not implemented");
	}

	@Test
	public void testFindDepartmentById() {
		// TODO: Implement test
		fail("Test not implemented");
	}
	

	@Test
	public void testFindDepartmentByIdWhenIdDoesNotExists() {
		// TODO: Implement test
		fail("Test not implemented");
	}
}
