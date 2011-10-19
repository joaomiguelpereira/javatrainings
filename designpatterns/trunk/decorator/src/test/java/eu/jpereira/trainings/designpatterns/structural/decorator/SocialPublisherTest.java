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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
/**
 * @author jpereira
 *
 */
public class SocialPublisherTest {

	@Test
	public void testAddSocialChannel() {
		SocialPublisher publisher = createPublisherUnderTest();
		//Check that is has no social channels configured
		assertEquals(0, publisher.getSocialChannelsCount());
		publisher.addSocialChannel(createMockedSocialChannel());
		assertEquals(1, publisher.getSocialChannelsCount());
	}
	
	@Test
	public void testRemoveSocialChannel() {
		SocialPublisher publisher = createPublisherUnderTest();
		SocialChannel channel = createMockedSocialChannel();
		
		publisher.addSocialChannel(channel);
		assertEquals(1, publisher.getSocialChannelsCount());
		//Now remove it 
		assertTrue(publisher.removeChannel(channel));
		assertEquals(0, publisher.getSocialChannelsCount());
		
	}
	@Test 
	public void testPublish() {
		//Should ask every Channel to publish a message
		SocialPublisher publisher= createPublisherUnderTest();
		//Now add two mocks
		SocialChannel channelTwitter = createMockedSocialChannel();
		SocialChannel channelFacebook = createMockedSocialChannel();
		//Add them to the publisher
		publisher.addSocialChannel(channelFacebook);
		publisher.addSocialChannel(channelTwitter);
		//Now call publish a message
		publisher.publish("Some message");
		
		verify(channelFacebook).deliverMessage("Some message");
		verify(channelTwitter).deliverMessage("Some message");
		
		
	}

	/**
	 * Factpry method for mocked social channels
	 * @return 
	 */
	protected SocialChannel createMockedSocialChannel() {
		
		return mock(SocialChannel.class);
	}

	/**
	 * @return
	 */
	protected SocialPublisher createPublisherUnderTest() {
		return new SocialPublisher();
	}
}
