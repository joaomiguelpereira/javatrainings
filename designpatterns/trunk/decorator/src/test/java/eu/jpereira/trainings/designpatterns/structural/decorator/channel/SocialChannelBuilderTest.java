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

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.FacebookChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.LinkedinChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.TwitterChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.dummy.DummySocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.dummy.TestDummyChannel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author jpereira
 * 
 */
public abstract class SocialChannelBuilderTest {

	@Test
	public void testDoNotBuildChannel() {
		SocialChannelBuilder builder = createSocialChannelBuilderUnderTest();
		assertNull(builder.buildChannel(new SocialChannelProperties()));
	}

	@Test
	public void testCreateTwitterChannel() {
		SocialChannelBuilder builder = createSocialChannelBuilderUnderTest();
		// ChannelProperties.
		SocialChannelProperties props = new SocialChannelProperties();

		SocialChannel channel = builder.buildChannel(props.putProperty(SocialChannelPropertyKey.NAME, TwitterChannel.NAME));
		assertNotNull(channel);
		assertTrue(channel instanceof TwitterChannel);
	}

	@Test
	public void testCreateFacebookChannel() {
		SocialChannelBuilder builder = createSocialChannelBuilderUnderTest();

		// ChannelProperties.
		SocialChannelProperties props = new SocialChannelProperties();

		SocialChannel channel = builder.buildChannel(props.putProperty(SocialChannelPropertyKey.NAME, FacebookChannel.NAME));
		assertNotNull(channel);
		assertTrue(channel instanceof FacebookChannel);
	}

	public void testCreateLinkedInChannel() {
		SocialChannelBuilder builder = createSocialChannelBuilderUnderTest();

		// ChannelProperties.
		SocialChannelProperties props = new SocialChannelProperties();

		SocialChannel channel = builder.buildChannel(props.putProperty(SocialChannelPropertyKey.NAME, LinkedinChannel.NAME));
		assertNotNull(channel);
		assertTrue(channel instanceof LinkedinChannel);
	}

	@Test
	public void testPlugChannel() {
		
		//Must extend the builder
		
		SocialChannelBuilder builder = new DummySocialChannelBuilder();
		
		String channelName = "DUMMY";
		//Use an dummyChannel
		
		
		SocialChannel channel = builder.buildChannel(new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, channelName));
		assertNotNull(channel);
		assertTrue(channel instanceof TestDummyChannel);
		
		//Must be able to use other channels

		SocialChannel channelTwitter = builder.buildChannel(new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TwitterChannel.NAME));
		assertNotNull(channelTwitter);
		assertTrue(channelTwitter instanceof TwitterChannel);
		
	}

	/**
	 * @return
	 */
	protected abstract SocialChannelBuilder createSocialChannelBuilderUnderTest();
}
