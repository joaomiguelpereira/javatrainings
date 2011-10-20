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
public class MessageTruncator extends SocialChannelDecorator {

	private int maxLength = 0;

	/**
	 * @param maxLength
	 */
	public MessageTruncator(int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @param i
	 * @param decoratedChannel
	 */
	public MessageTruncator(int i, SocialChannel decoratedChannel) {
		this.maxLength = i;
		this.delegate = decoratedChannel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.jpereira.trainings.designpatterns.structural.decorator.channel.
	 * SocialChannel#deliverMessage(java.lang.String)
	 */
	@Override
	public void deliverMessage(String message) {
		if (message.length() > maxLength) {
			StringBuilder builder = new StringBuilder();
			builder.append(message.substring(0, maxLength - 3));
			builder.append("...");
			message = builder.toString();
		}
		delegate.deliverMessage(message);

	}

}
