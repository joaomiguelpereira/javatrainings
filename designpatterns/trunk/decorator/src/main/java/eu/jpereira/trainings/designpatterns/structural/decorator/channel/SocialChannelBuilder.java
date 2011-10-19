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
package eu.jpereira.trainings.designpatterns.structural.decorator.channel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jpereira
 * 
 */
public class SocialChannelBuilder {

	private Map<String, SocialChannel> cachedChannels;
	// Map <name
	private Map<String, Class<? extends SocialChannel>> pluggedChannels;

	public SocialChannelBuilder() {
		this.pluggedChannels = createChannelsList();
		this.cachedChannels = createChachedChannedlList();
		this.addDefaultChannels();
	}

	/**
	 * Build a default list off channels. Others can be plugged either by
	 * extending this class and calling the method plugChannel() in constructor,
	 * for example;
	 */
	private void addDefaultChannels() {
		this.pluggedChannels.put(TwitterChannel.NAME, TwitterChannel.class);
		this.pluggedChannels.put(FacebookChannel.NAME, FacebookChannel.class);
		this.pluggedChannels.put(LinkedinChannel.NAME, LinkedinChannel.class);
	}

	/**
	 * @return
	 */
	protected Map<String, Class<? extends SocialChannel>> createChannelsList() {
		return new HashMap<String, Class<? extends SocialChannel>>();
	}

	/**
	 * Factory method
	 */
	protected Map<String, SocialChannel> createChachedChannedlList() {
		return new HashMap<String, SocialChannel>();

	}

	/**
	 * Find an appropriate channel according to the properties
	 * 
	 * @param channelProperties
	 * @return
	 */
	public SocialChannel buildChannel(SocialChannelProperties channelProperties) {

		// lookup channel by name
		SocialChannel instance = null;

		String channelName = channelProperties.getProperty(ChannelPropertyKey.NAME);
		if (channelName != null && this.pluggedChannels.containsKey(channelName)) {

			// Try the cache
			instance = this.cachedChannels.get(channelName);
			if (instance == null) {
				instance = instantiateChannel(this.pluggedChannels.get(channelName));
				this.cachedChannels.put(channelName, instance);
			}

		}

		return instance;
	}

	/**
	 * @param claszz
	 * @return
	 */
	private SocialChannel instantiateChannel(Class<? extends SocialChannel> claszz) {
		SocialChannel instance = null;
		try {
			instance = claszz.newInstance();
		} catch (InstantiationException e) {
			// Just log it
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// just log it
			e.printStackTrace();
		}
		return instance;
	}

	/**
	 * @param put
	 * @param clazz
	 */
	protected void plugChannel(SocialChannelProperties put, Class<? extends SocialChannel> clazz) {
		this.pluggedChannels.put(put.getProperty(ChannelPropertyKey.NAME), clazz);

	}

}