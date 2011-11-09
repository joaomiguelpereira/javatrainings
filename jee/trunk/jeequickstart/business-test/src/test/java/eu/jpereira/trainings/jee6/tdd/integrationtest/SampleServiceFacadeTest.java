/*
 * Copyright 2012 Joao Pereira
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

package eu.jpereira.trainings.jee6.tdd.integrationtest;

import javax.ejb.EJB;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.jeeunit.JeeunitRunner;

import eu.jpereira.trainings.jee6.tdd.facade.exceptions.CouldNotCreateSampleBusinessEntity;
import eu.jpereira.trainings.jee6.tdd.model.Author;
import eu.jpereira.trainings.jee6.tdd.service.facade.SampleServiceFacade;

@RunWith(JeeunitRunner.class)
public class SampleServiceFacadeTest {

	@EJB
	private SampleServiceFacade facade;

	@Test
	public void testCreateBusinessEntity()
			throws CouldNotCreateSampleBusinessEntity {
		Author entity = new Author();
		entity.setName("Author's name");
		facade.createSampleBusinessEntity(entity);
	
	}
}
