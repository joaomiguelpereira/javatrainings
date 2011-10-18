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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

/**
 * @author jpereira
 * 
 */
public class InternetManagerTest {

	@Test
	public void testConnect() {
		InternetManager sut = createInternetManagerUnderTest();
		//Set a mocked Network Manager
		ConnectionManager mockConnectionManager = createMockConnectionManager();
		sut.setConnectionManager(mockConnectionManager);
		//When connect is called, the message should be sent to the connection manager
		sut.connect();
		verify(mockConnectionManager).startConnection();
		
		

	}

	@Test
	public void testDisconect(){
		InternetManager sut = createInternetManagerUnderTest();
		//Set a mocked Network Manager
		ConnectionManager mockConnectionManager = createMockConnectionManager();
		sut.setConnectionManager(mockConnectionManager);
		//When disconnect is called, the message should be sent to the connection manager
		sut.disconnect();
		verify(mockConnectionManager).endConnection();

	}

	@Test
	public void tetGetUpTime() {
		InternetManager sut = createInternetManagerUnderTest();
		//Set a mocked Network Manager
		ConnectionManager mockConnectionManager = createMockConnectionManager();
		sut.setConnectionManager(mockConnectionManager);
		
		//Stub return values
		when(mockConnectionManager.getUpTime()).thenReturn(60000L);
		assertEquals(60000L, sut.getUpTime());
		
	}


	/**
	 * Factory for mocked ConnectionManager
	 * @return mocked ConnectionManager
	 */
	protected ConnectionManager createMockConnectionManager() {
		
		return mock(ConnectionManager.class);
	}

	
	/**
	 * Factory for InternetManager Under Test
	 * @return an instance of InternetManager to Test
	 */
	protected InternetManager createInternetManagerUnderTest() {
		return new InternetManager();
		
	}
}
