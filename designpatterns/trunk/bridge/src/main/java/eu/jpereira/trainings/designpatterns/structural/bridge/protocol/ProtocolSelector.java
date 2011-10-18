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
package eu.jpereira.trainings.designpatterns.structural.bridge.protocol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author jpereira
 * 
 */
public class ProtocolSelector {

	private List<Protocol> availableProtocols = createProtocolsList();

	/**
	 * @return
	 */
	public Protocol selectGoodProtocol() {
		// Some algorithm here to select the best protocol.
		// Dummy implementation, use dummy algorithm
		return availableProtocols.get(new Random().nextInt(availableProtocols.size() - 1));

	}

	/**
	 * Factory method
	 * 
	 * @return
	 */
	private List<Protocol> createProtocolsList() {
		List<Protocol> list = new ArrayList<Protocol>();
		list.add(new GSMProtocol());
		list.add(new WIFIProtocol());
		list.add(new WIMAXProtocol());
		// Call
		list.addAll(createAditionalProtocols());
		return list;
	}

	/**
	 * factory method for additional protocols. If you want to add more
	 * protocols, override this method and return a list with more protocols
	 * 
	 * @return
	 */
	protected Collection<Protocol> createAditionalProtocols() {
		return Collections.<Protocol> emptyList();
	}

	/**
	 * Add a new protocol
	 * 
	 * @param protocol
	 */
	public void addProtocol(Protocol protocol) {
		this.availableProtocols.add(protocol);
	}

	/**
	 * @return
	 */
	public int getProtocolCount() {
		
		return this.availableProtocols.size();
	}

}
