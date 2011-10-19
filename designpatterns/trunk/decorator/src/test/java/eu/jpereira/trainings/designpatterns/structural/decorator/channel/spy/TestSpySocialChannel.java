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
package eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

/**
 * This is a test spy for the SocialChannel. It will record any message sent
 * here to a list
 * 
 * @author jpereira
 * 
 */
@Ignore
public class TestSpySocialChannel implements SocialChannel {

	public static final String NAME = "spy";
	private List<String> messagesDelivered ;

	public TestSpySocialChannel() {
		this.messagesDelivered= new ArrayList<String>();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.decorator.channel.
	 * SocialChannel#deliverMessage(java.lang.String)
	 */
	@Override
	public void deliverMessage(String string) {
		// Add to the list
		this.messagesDelivered.add(string);

	}

	/**
	 * @return
	 */
	public String lastMessagePublished() {
		return this.messagesDelivered.get(this.messagesDelivered.size()-1);
	}

}
