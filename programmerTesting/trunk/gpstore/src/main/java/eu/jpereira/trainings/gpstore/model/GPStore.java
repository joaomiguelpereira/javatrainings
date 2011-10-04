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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.trainings.gpstore.exceptions.NotImplementedException;
import eu.jpereira.trainings.gpstore.model.exceptions.DuplicateDepartmentException;
import eu.jpereira.trainings.gpstore.model.exceptions.NoSuchDepartmentException;

/**
 * This abstract class defines a General Purpose Store.
 * 
 * @author jpereira
 * 
 */
/**
 * @author jpereira
 *
 */
/**
 * @author jpereira
 *
 */
/**
 * @author jpereira
 *
 */
public class GPStore extends AbstractEntity {

	// private data
	private Map<Long, Department> departments;

	/**
	 * Public constructor
	 * 
	 * @param id
	 *            See @See {@link AbstractEntity}
	 */
	public GPStore(long id) {
		super(id);
		// Initialize private data
		this.departments = new HashMap<Long, Department>();
	}

	/**
	 * Add a new department to the Store. The department is added only if it
	 * does not exists.
	 * 
	 * @param department
	 *            Department instance to add
	 * @throws DuplicateDepartmentException
	 *             If the department already exist in the store
	 */
	public void addDepartment(Department department) throws DuplicateDepartmentException {
		// Should not add duplicated departments
		if (!this.departments.containsKey(department.getId())) {
			// add to the collection
			this.departments.put(department.getId(), department);

		} else {
			throw new DuplicateDepartmentException();
		}

	}

	/**
	 * Remove a department from the Store
	 * 
	 * @param departmentId
	 *            the id of the Department
	 * @throws NoSuchDepartmentException
	 *             if none department with departmentId exists
	 */
	public void removeDepartment(long departmentId) throws NoSuchDepartmentException {
		if (this.departments.containsKey(departmentId)) {
			this.departments.remove(departmentId);
		} else {
			throw new NoSuchDepartmentException();
		}
	}

	/**
	 * Get a list of all departments in the Store. The returned list is a copy
	 * of the current state
	 * 
	 * @return A list of departments. If no departments are found, the list will
	 *         contain zero elements
	 */
	public List<Department> getAllDepartments() {
		return new ArrayList<Department>(this.departments.values());
	}

	/**
	 * Find a Department whose name is equals to departmentName argument.This
	 * operation is <b>not</b> case sensitive.
	 * 
	 * @param departmentName
	 *            The name of the department to find.
	 * @return The Department with name equals to argument departmentName. If
	 *         none found, <b>null</b> is returned.
	 */
	public Department findDepartmentByName(String departmentName) {
		throw new NotImplementedException();
	}

	/**
	 * Get the count of Departments in this store
	 * 
	 * @return The total number of Departments in this store.
	 */
	public int getDepartmentCount() {
		return this.departments.size();
	}

	/**
	 * Find an department if you know its ID
	 * @param id the department id
	 * @return a department or null if none found with the argument id
	 */
	public GPStore findDepartment(long id) {

		throw new NotImplementedException();
	}

}
