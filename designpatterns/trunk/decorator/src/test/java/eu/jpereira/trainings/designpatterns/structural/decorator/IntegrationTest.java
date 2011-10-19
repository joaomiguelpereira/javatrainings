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

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.DefaultSocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;

/**
 * @author jpereira
 *
 */
public class IntegrationTest {

	@Test
	public void testSendMessage() {
		SocialPublisher publisher = createSocialPublisher();
		//create a ChannelBuilder
		SocialChannelBuilder builder = new DefaultSocialChannelBuilder();
		//Add three channels
		publisher.addSocialChannel(builder.buildChannel(new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, "twitter")));
		publisher.addSocialChannel(builder.buildChannel(new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, "facebook")));
		publisher.addSocialChannel(builder.buildChannel(new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, "linkedin")));

		
		publisher.publish("Hello World!!");
	}

	
	/**
	 * @return
	 */
	private SocialPublisher createSocialPublisher() {
		// TODO Auto-generated method stub
		return new SocialPublisher();
	}
}
