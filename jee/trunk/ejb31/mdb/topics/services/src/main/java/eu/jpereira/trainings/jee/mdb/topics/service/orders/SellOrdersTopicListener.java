package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import eu.jpereira.trainings.jee.mdb.topics.model.orders.SellOrder;
import eu.jpereira.trainings.jee.mdb.topics.service.orders.SellOrderCounter.SellOrderType;

public abstract class SellOrdersTopicListener implements
		javax.jms.MessageListener {

	private @EJB
	SellOrderCounter sellOrdersCounter;

	protected abstract SellOrderType getType();

	@Override
	public void onMessage(Message message) {
		System.out.println("Handling Message on "
				+ this.getClass().getSimpleName());
		if (message instanceof ObjectMessage) {

			ObjectMessage objectMessage = (ObjectMessage) message;
			try {

				if (objectMessage.getObject() instanceof SellOrder) {
					SellOrder sellOrder = (SellOrder) objectMessage.getObject();
					System.out.println("----handling price "+sellOrder.getTotalPrice()+" on class "+this.getClass().getSimpleName());
					// Will only count the number of hits in this MDB
					sellOrdersCounter.hitOrderType(getType());
				}

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
