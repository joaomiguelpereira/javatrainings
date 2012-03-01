package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/topics/orders"),
		@ActivationConfigProperty(propertyName="messageSelector", propertyValue="type = 'BIG'"),
		@ActivationConfigProperty(propertyName="subscriptionDurability", propertyValue="durable")})
public class BigOrdersTopicListener extends SellOrdersTopicListener implements
		javax.jms.MessageListener {

	@Override
	protected SellOrderType getType() {
		return SellOrderType.BIG;
	}

}
