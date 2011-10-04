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

import java.util.Iterator;

import eu.jpereira.trainings.gpstore.model.AbstractEntity;
import eu.jpereira.trainings.gpstore.model.Department;
import eu.jpereira.trainings.gpstore.model.GPStore;

/**
 * @author jpereira
 * 
 */
public class GPStoreReporter extends AbstractReporter {

	/**
	 * @param name
	 *            the name of this reporter, usually named after the entity
	 * @see AbstractReporter#AbstractReporter()
	 */
	public GPStoreReporter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.gpstore.reporting.Reporter#getAllAsXml()
	 */
	@Override
	public String getAsJSON(AbstractEntity entity) {
		// Poor hack :( We will see how we can avoid this later with generics
		// Pray!!!
		GPStore store = (GPStore) entity;

		StringBuilder json = new StringBuilder();
		json.append("{name: \"");
		json.append(store.getName());
		json.append("\", ");
		json.append("id: ");
		json.append(store.getId());

		// has reporter for departments?
		Reporter departmentsReporter = getEntityReporter(Department.class);
		// has any departments
		if (store.getDepartmentCount() > 0 && departmentsReporter != null) {

			json.append(", departments: [");
			for (Iterator<Department> it = store.getAllDepartments().iterator(); it.hasNext();) {
				Department department = it.next();
				json.append(departmentsReporter.getAsJSON(department));
				if (it.hasNext()) {
					json.append(", ");
				}
			}
			json.append("]");
		}
		json.append("}");
		return json.toString();

	}
}
