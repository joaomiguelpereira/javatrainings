package eu.jpereira.trainings.jee.mdb.queues.orders.processor;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import eu.jpereira.trainings.jee.mdb.queues.model.jobs.Job;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.Orders;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.SellOrder;

//TODO: Must indicate the container this is a JMS Message Listener, or a Message Driven Bean. Use the following activation config:

/*
 @MessageDriven(activationConfig = {
 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
 @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queues/orders") })*/
public class OrderProcessor implements javax.jms.MessageListener {

	private @EJB
	Orders ordersDao;

	@Override
	public void onMessage(Message receivedMessage) {

		// This is the method that will be called by the container when a
		// message arrives to the destination configured in the activation
		// config

		if (receivedMessage instanceof ObjectMessage) {

			ObjectMessage message = (ObjectMessage) receivedMessage;

			try {

				Job job = (Job) message.getObject();

				SellOrder order = ordersDao.findById(job.getDomainObjectId());

				if (order != null) {

					// Move the status of the order to the next
					order.moveNextState();

				}

			} catch (JMSException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}

}
