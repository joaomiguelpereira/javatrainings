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
package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

/**
 * @author jpereira
 * 
 */
public class URLAppender extends SocialChannelDecorator {

	private String url;

	/**
	 * @param url
	 */
	public URLAppender(String url) {
		this.url = url;
	}

	/**
	 * @param string
	 * @param channel
	 */
	public URLAppender(String url, SocialChannel channel) {
		this.url = url;
		this.delegate = channel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.decorator.channel.
	 * SocialChannel#deliverMessage(java.lang.String)
	 */
	@Override
	public void deliverMessage(String message) {
		StringBuilder builder = new StringBuilder();
		builder.append(message);
		builder.append(" ");
		builder.append(this.url);
		if (delegate != null) {
			delegate.deliverMessage(builder.toString());
		}

	}

}
