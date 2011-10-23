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
package eu.jpereira.trainings.designpatterns.structural.flyweight;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.flyweight.fakes.FakeHTTPHandler;

/**
 * @author jpereira
 * 
 */
public class ServerIntegrationTest {
	protected static Server server;
	private List<Thread> threads = new ArrayList<Thread>(); 

	@BeforeClass
	public static void startServer() throws Exception {
		server = new Server(8090);
		server.setHandler(new FakeHTTPHandler());
		server.start();

	}

	@Test
	public void testServer() throws IOException, InterruptedException {
		
		//Create some big number of clients
		System.err.println("Testing 5 Clients....");
		int numberOfClients = 5;
		for (int i=0; i< numberOfClients; i++ ) {
			Thread thread = new Thread(new TestClient());
			thread.start();
			thread.join();
			threads.add(thread);
		}
		
		
	}

	@AfterClass
	public static void stopServer() throws Exception {
		server.stop();
	}

	
	private class TestClient implements Runnable {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// create an http client
			try {
				URL url = new URL("http://localhost:8090/?city=aveiro&la=1111&lo=9899");
				URLConnection connection = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
				}
				in.close();
			} catch (MalformedURLException e) {
				fail("Error");
				e.printStackTrace();
			} catch (IOException e) {
				fail("Error");
				e.printStackTrace();
			}

		}

	}

}
