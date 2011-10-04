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

import java.util.HashMap;
import java.util.Map;

import eu.jpereira.trainings.gpstore.model.AbstractEntity;

/**
 * An abstraction of reporter
 * 
 * @author jpereira
 * 
 */

public abstract class AbstractReporter implements Reporter {

	// private state
	private Map<Class<?>, Reporter> reporters;

	

	// constructor with immutable name of the entity for which this reporting is
	// reporting data
	public AbstractReporter() {
		this.reporters = new HashMap<Class<?>, Reporter>();
		
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.gpstore.reporting.Reporter#addEntityReporterReporter
	 * (eu.jpereira.trainings.gpstore.reporting.Reporter, java.lang.Class)
	 */
	@Override
	public <T extends AbstractEntity> void addEntityReporter(Reporter childReporter, Class<T> entityClazz) {
		this.reporters.put(entityClazz, childReporter);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.gpstore.reporting.Reporter#getEntityReporter(java
	 * .lang.Class)
	 */
	@Override
	public Reporter getEntityReporter(Class<?> entityClazz) {
		return this.reporters.get(entityClazz);
	}

}
