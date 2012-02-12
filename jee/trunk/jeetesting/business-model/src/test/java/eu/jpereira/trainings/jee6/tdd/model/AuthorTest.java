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
package eu.jpereira.trainings.jee6.tdd.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import eu.jpereira.trainings.jee6.tdd.unittesting.AbstractJEETest;

/**
 * @author joaomiguel.pereira@gmail.com
 * 
 */
public class AuthorTest extends AbstractJEETest {
	
	@Test
	public void testPersistAuthor() {
		
		beginTx();
		Author author = new Author();
		author.setName("Test");
		em.persist(author);
		commitTx();
		assertNotNull(author.getId());
		
		//Find b ID
		assertNotNull(em.find(Author.class, author.getId()));

	}
}
