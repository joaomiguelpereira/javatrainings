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
package eu.jpereira.trainings.jee6.tdd.service.facade.bean;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.tdd.facade.exceptions.CouldNotCreateSampleBusinessEntity;
import eu.jpereira.trainings.jee6.tdd.model.Author;
import eu.jpereira.trainings.jee6.tdd.service.facade.SampleServiceFacade;
import eu.jpereira.trainings.jee6.tdd.service.pojo.SamplePojoInterface;

/**
 * @author joaomiguel.pereira@gmail.com
 * 
 */

@Stateless
public class SampleServiceFacadeBean implements SampleServiceFacade {
	//Logger
	Logger LOG = Logger.getLogger(SampleServiceFacadeBean.class.getName());
	private SamplePojoInterface samplePojo;
	/**
	 * Constructor
	 */
	@Inject
	public SampleServiceFacadeBean(SamplePojoInterface samplePojo) {
		this.samplePojo = samplePojo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.jee.training.service.facade.SampleServiceFacade#
	 * createSampleBusinessEntity
	 * (eu.jpereira.jee.training.model.SampleBusinessEntity)
	 */
	@Override
	public void createSampleBusinessEntity(Author entity)
			throws CouldNotCreateSampleBusinessEntity {
		System.out.println("Implement method...");
		this.samplePojo.sampleMethod(entity);

	}

}
