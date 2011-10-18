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

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.Protocol;
import eu.jpereira.trainings.designpatterns.structural.bridge.protocol.ProtocolSelector;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author jpereira
 * 
 */
public abstract class ConnectionManagerTest {

	@Test
	public void testStartConnection() {
		// Create the System Under Test
		ConnectionManager connectionManager = createConnectionManagerUnderTest();
		// Create a Mocked protocol Selector
		ProtocolSelector mockedProtocolSelector = createMockedProtocolSelector();

		// Stub the call of getGoodProtocol with a mock
		Protocol mockedProtocol = createMockedProtocol();
		when(mockedProtocolSelector.selectGoodProtocol()).thenReturn(mockedProtocol);
		connectionManager.setProtocolSelector(mockedProtocolSelector);

		// exercise
		connectionManager.startConnection();
		verify(mockedProtocolSelector).selectGoodProtocol();
		verify(mockedProtocol).startSession();

	}

	@Test
	public void testEndConnection() {
		// Create the System Under Test
		ConnectionManager connectionManager = createConnectionManagerUnderTest();
		// Create a Mocked protocol Selector
		ProtocolSelector mockedProtocolSelector = createMockedProtocolSelector();

		// Stub the call of getGoodProtocol with a mock
		Protocol mockedProtocol = createMockedProtocol();
		when(mockedProtocolSelector.selectGoodProtocol()).thenReturn(mockedProtocol);
		connectionManager.setProtocolSelector(mockedProtocolSelector);

		// exercise
		connectionManager.endConnection();
		verify(mockedProtocolSelector).selectGoodProtocol();
		verify(mockedProtocol).endSession();

	}

	@Test
	public void testGetUpTime() {

		// Create the System Under Test
		ConnectionManager connectionManager = createConnectionManagerUnderTest();
		// Create a Mocked protocol Selector
		ProtocolSelector mockedProtocolSelector = createMockedProtocolSelector();

		// Stub the call of getGoodProtocol with a mock
		Protocol mockedProtocol = createMockedProtocol();
		when(mockedProtocolSelector.selectGoodProtocol()).thenReturn(mockedProtocol);
		connectionManager.setProtocolSelector(mockedProtocolSelector);

		// stub 60000 for getUpTime in protocol
		when(mockedProtocol.getUpTime()).thenReturn(60000L);
		// exercise
		assertEquals(60000L, connectionManager.getUpTime());
		verify(mockedProtocolSelector).selectGoodProtocol();
	}

	/**
	 * Factory method for the ConnectionManager underTest
	 * 
	 * @return
	 */
	protected abstract ConnectionManager createConnectionManagerUnderTest();

	/**
	 * Factory method for mocked protocol selector
	 * 
	 * @return
	 */
	
	protected abstract ProtocolSelector createMockedProtocolSelector();

	/**
	 * Factory method for a Mocked Protocol instance
	 * 
	 * @return
	 */
	protected abstract Protocol createMockedProtocol();

}
