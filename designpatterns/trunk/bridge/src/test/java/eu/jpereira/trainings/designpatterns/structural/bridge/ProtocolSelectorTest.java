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
package eu.jpereira.trainings.designpatterns.structural.bridge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.Protocol;
import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ProtocolSelector;

/**
 * @author jpereira
 * 
 */
public class ProtocolSelectorTest {

	@Test
	public void testHasDefaultProtocols() {
		ProtocolSelector selector = createProtocolSelector();
		assertEquals(getProtocolCount(), selector.getProtocolCount());
	}

	@Test
	public void testSelectGoodProtocol() {
		ProtocolSelector selector = createProtocolSelector();
		assertNotNull(selector.selectGoodProtocol());
	}

	@Test
	public void testAddProtocol() {
		ProtocolSelector selector = createProtocolSelector();
		int protocolCount = selector.getProtocolCount();
		// Add some mock
		selector.addProtocol(mock(Protocol.class));
		assertEquals(protocolCount + 1, selector.getProtocolCount());
	}

	/**
	 * Factory method for System UnderTest
	 * 
	 * @return
	 */
	protected ProtocolSelector createProtocolSelector() {
		return new ProtocolSelector();
	}

	/**
	 * Override if you extend the class under test. This should return the
	 * number of protocols you should have configured in the selector
	 * 
	 * @return
	 */
	protected int getProtocolCount() {
		return 3;
	}

}
