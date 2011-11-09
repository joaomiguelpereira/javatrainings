/*
 * Copyright 2011 Joao Pereira
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
 *
 */
package eu.jpereira.trainings.jee6.tdd.service.facade;

import javax.ejb.Remote;

import eu.jpereira.trainings.jee6.tdd.facade.exceptions.CouldNotCreateSampleBusinessEntity;
import eu.jpereira.trainings.jee6.tdd.model.Author;

/**
 * Sample ServiceFacade. Generally, its a remote view
 * @author joaomigue.pereira@gmail.com
 *
 */
@Remote
public interface SampleServiceFacade {

	/**
	 * Create a {@link Author}
	 * @param entity an detached entity
	 * @throws CouldNotCreateSampleBusinessEntity
	 */
	void createSampleBusinessEntity(Author entity) throws CouldNotCreateSampleBusinessEntity;
}
