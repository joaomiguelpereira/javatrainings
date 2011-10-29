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
package eu.jpereira.trainings.designpatterns.behavioral.iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.Command;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.CommandJob;
/**
 * @author jpereira
 *
 */
public class CommandJobIteratorTest {

	
	@SuppressWarnings("unused")
	@Test
	public void testIterator() {
		CommandJob job = createCommandJob();
		
		//TODO: EXERCISE uncomment. Go to CommandJob and complete the TODOs
		//assertNotNull(job.iterator());
		//TODO: EXERCISE uncomment
		//Iterator<Command> it = job.iterator();
		int count = 0;
		//Iterate 
		//TODO: EXERCISE Iterate over the iterator returned from job.iterator()
		
		/*while ( it.hasNext() ) {
			count++;
			Command command = it.next();
		}*/
		assertEquals(3, count);
	}

	/**
	 * @return
	 */
	protected CommandJob createCommandJob() {
		CommandJob job = new CommandJob();
		//crete three new mocked commands
		job.addCommand(mock(Command.class));
		job.addCommand(mock(Command.class));
		job.addCommand(mock(Command.class));
		return job;
	}
}
