package eu.jpereira.trainings.jee.mdb.topics.service.orders;




//TODO: Configure this class as being an MDB listening on the created topic. 
//Filter messages received by this MDB. Only messages with a string property type=BIG will be handled
//Use the following ActivatioConfic

/*
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/topics/orders"),
		@ActivationConfigProperty(propertyName="messageSelector", propertyValue="type = 'BIG'"),
		@ActivationConfigProperty(propertyName="subscriptionDurability", propertyValue="durable")})
		
*/

//TODO: Extends from abstract SellOrdersTopicListener and implement the interface javax.jms.MessageListener
public class BigOrdersTopicListener /*extends SellOrdersTopicListener implements
		javax.jms.MessageListener */{

	//TODO: Implement the abstract method from SellOrdersTopicListener

	/*@Override
	protected SellOrderType getType() {
		return SellOrderType.BIG;
	}*/

}
