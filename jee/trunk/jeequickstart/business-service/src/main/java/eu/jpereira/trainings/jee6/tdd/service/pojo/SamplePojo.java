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
package eu.jpereira.trainings.jee6.tdd.service.pojo;

import eu.jpereira.trainings.jee6.tdd.model.Author;


/**
 * @author joaomiguel.pereira@gmail.com
 * 
 */

public class SamplePojo implements SamplePojoInterface {

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.jee6.tdd.service.pojo.SamplePojoInterface#sampleMethod(eu.jpereira.trainings.jee6.tdd.model.Author)
	 */
	@Override
	public void sampleMethod(Author entity) {
		System.out.println("Sample Method: "+entity.getName());
		
	}

	
}
