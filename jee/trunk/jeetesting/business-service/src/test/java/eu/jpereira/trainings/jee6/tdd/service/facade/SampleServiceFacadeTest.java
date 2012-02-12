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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import eu.jpereira.trainings.jee6.tdd.facade.exceptions.CouldNotCreateSampleBusinessEntity;
import eu.jpereira.trainings.jee6.tdd.model.Author;
import eu.jpereira.trainings.jee6.tdd.service.facade.bean.SampleServiceFacadeBean;
import eu.jpereira.trainings.jee6.tdd.service.pojo.SamplePojoInterface;
/**
 * @author joaomiguel.pereira@gmail.com
 * 
 */
public class SampleServiceFacadeTest {

	private SamplePojoInterface pojoDOC;
	@Test
	public void testFacade() throws CouldNotCreateSampleBusinessEntity {
		SampleServiceFacade facade = createSampleServiceFacade();
		
		//Create some dummy Author
		Author author = new Author();
		author.setName("Author's name");
		facade.createSampleBusinessEntity(author);
		verify(pojoDOC).sampleMethod(author);
		
		
	}

	/**
	 * @return
	 */
	private SampleServiceFacade createSampleServiceFacade() {
	
		this.pojoDOC = mock(SamplePojoInterface.class);
		return new SampleServiceFacadeBean(pojoDOC);
	}

}
