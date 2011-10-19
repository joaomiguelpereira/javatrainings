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
public class SocialChannelProperties {

	private Map<SocialChannelPropertyKey, String> props;

	/**
	 * 
	 */
	public SocialChannelProperties() {
		this.props = new HashMap<SocialChannelPropertyKey, String>();
	}

	/**
	 * @param key
	 * @param propValue
	 */
	public SocialChannelProperties putProperty(SocialChannelPropertyKey key, String propValue) {
		this.props.put(key, propValue);
		return this;

	}

	/**
	 * @param key
	 * @return
	 */
	public String getProperty(SocialChannelPropertyKey key) {
		return this.props.get(key);
	}
}
