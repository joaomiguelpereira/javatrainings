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
package eu.jpereira.trainings.jee6.tdd.unittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
/**
 * @author joaomiguel.pereira@gmail.com
 * 
 */
@Ignore
public abstract class AbstractJEETest {
	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	@BeforeClass
	public static void initiTestCase() {
		emf = Persistence.createEntityManagerFactory("tddPU");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void shutDown() {
		em.close();
		emf.close();

	}


	@Ignore
	protected void beginTx() {
		em.getTransaction().begin();
	}

	@Ignore
	protected void commitTx() {
		em.flush();
		em.getTransaction().commit();

	}

	
	/**
	 * Asserts that exists the expected number of entities in the DB
	 * 
	 * @param expected
	 * @param clazz
	 */
	protected void assertEntitySize(int expected, Class<?> clazz) {
		assertEquals(expected, getEntityCount(clazz));
	}

	protected int getEntityCount(Class<?> clazz) {
		String q = "select x from " + clazz.getSimpleName() + " x";
		return em.createQuery(q, clazz).getResultList().size();

	}

	protected void detach(Object object) {
		assertTrue(em.contains(object));
		em.detach(object);
		assertFalse(em.contains(object));

	}

}
