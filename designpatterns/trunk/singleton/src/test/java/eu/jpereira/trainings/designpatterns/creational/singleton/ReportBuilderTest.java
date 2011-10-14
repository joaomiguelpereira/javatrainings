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
package eu.jpereira.trainings.designpatterns.creational.singleton;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author jpereira
 * 
 */
public class ReportBuilderTest {

	@Before
	public void cleanUpSingletonReference() {
		ReportBuilder.resetInstance();
	}

	/**
	 * Test for multhithreading
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testMultiThreading() throws InterruptedException {

		List<Thread> threads = new ArrayList<Thread>();
		// Save the references
		List<ReportBuilder> references = Collections.synchronizedList(new ArrayList<ReportBuilder>());
		// Create n treads
		for (int i = 0; i < 10; i++) {
			Thread worker = new Thread(new Worker(i, references));
			threads.add(worker);
			worker.start();
			// worker.join();

		}

		// Don't go away until all childs have finished

		for (Thread thread : threads) {
			while (thread.isAlive()) {
				// just wait it to die
			}
			System.out.println("Thread " + thread.getId() + " died!");

		}
		// assert all references are for the same object
		for (int i = 0; i < references.size(); i++) {
			ReportBuilder expected = references.get(i);
			for (int j = i; j < references.size(); j++) {
				assertEquals(expected, references.get(j));
			}
		}

	}

	@Test
	public void testGetSingleton() {
		ReportBuilder builder = ReportBuilder.getInstance();
		assertNotNull(builder);
	}

	/**
	 * Will measure init type for the lazy singleton.
	 */
	@Test
	public void measureInitializeTime() {
		long startTime = System.currentTimeMillis();
		ReportBuilder.getInstance();
		System.out.println("First call took: " + (System.currentTimeMillis() - startTime) + " ms");

		startTime = System.currentTimeMillis();
		ReportBuilder.getInstance();
		System.out.println("Second call took: " + (System.currentTimeMillis() - startTime) + " ms");

	}

	class Worker implements Runnable {

		private int number;
		private List<ReportBuilder> myReferences;

		public Worker(int number, List<ReportBuilder> references) {
			this.setNumber(number);
			this.myReferences = references;

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// Dummy call
			this.myReferences.add(ReportBuilder.getInstance());

		}

		/**
		 * @return the number
		 */
		public int getNumber() {
			return number;
		}

		/**
		 * @param number
		 *            the number to set
		 */
		public void setNumber(int number) {
			this.number = number;
		}

	}
}
