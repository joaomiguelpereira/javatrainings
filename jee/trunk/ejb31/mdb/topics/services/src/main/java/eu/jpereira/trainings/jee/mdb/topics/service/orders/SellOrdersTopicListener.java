package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;

//TODO: This is the base class for all MDBs. Implement the interface javax.jms.MessageListener

public abstract class SellOrdersTopicListener /*implements javax.jms.MessageListener */{

	
	//TODO: Inject an EJB of type SellOrderCounter. Analyze the SellOrderCounter
	//private SellOrderCounter sellOrdersCounter;

	//This abstract method is implemented by concrete MDBs
	protected abstract SellOrderType getType();

	//TODO: Implement the interface from javax.jms.MessageListener
	/*
	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {

			ObjectMessage objectMessage = (ObjectMessage) message;
			try {

				if (objectMessage.getObject() instanceof SellOrder) {
					SellOrder sellOrder = (SellOrder) objectMessage.getObject();
			
					// Will only count the number of hits in this MDB
					sellOrdersCounter.hitOrderType(getType());
				}

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}*/

}
