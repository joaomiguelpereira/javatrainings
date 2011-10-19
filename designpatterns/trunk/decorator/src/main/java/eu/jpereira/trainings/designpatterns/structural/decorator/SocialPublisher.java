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
package eu.jpereira.trainings.designpatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

/**
 * @author jpereira
 * 
 */
public class SocialPublisher {

	private List<SocialChannel> channels;

	public SocialPublisher() {
		this.channels = createSocialChannelList();
	}

	/**
	 * @param textMessage
	 */
	public void publish(String textMessage) {
		//For each channels, deliver the message
		for (SocialChannel channel : this.channels ) {
			channel.deliverMessage(textMessage);
		}

	}

	/**
	 * @return
	 */
	public int getSocialChannelsCount() {
		return this.channels.size();
	}

	/**
	 * @param channel
	 */
	public void addSocialChannel(SocialChannel channel) {
		this.channels.add(channel);
	}

	/**
	 * Factory method
	 * 
	 * @return
	 */
	protected List<SocialChannel> createSocialChannelList() {

		return new ArrayList<SocialChannel>();
	}

	/**
	 * @param channel
	 * @return
	 */
	public boolean removeChannel(SocialChannel channel) {
		boolean removed = false;
		if (this.channels.contains(channel)) {
			this.channels.remove(channel);
			removed = true;
		}
		return removed;
	}
}
