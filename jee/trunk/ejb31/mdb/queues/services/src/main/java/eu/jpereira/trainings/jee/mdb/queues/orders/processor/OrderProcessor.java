package eu.jpereira.trainings.jee.mdb.queues.orders.processor;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import eu.jpereira.trainings.jee.mdb.queues.model.jobs.Job;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.OrderStatus;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.Orders;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.SellOrder;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queues/orders") })
public class OrderProcessor implements javax.jms.MessageListener{


	private @EJB Orders ordersDao;
	
	@Override
	public void onMessage(Message arg0) {
		System.err.println("Receiving message");
	
		//just call the service 
		if ( arg0 instanceof ObjectMessage ) {
			
			ObjectMessage message = (ObjectMessage)arg0;
			
			try {
				
				Job job = (Job)message.getObject();
				SellOrder order = ordersDao.findById(job.getDomainObjectId());
				if ( order!=null) {
					
					OrderStatus status =  order.moveNextState();
					System.out.println("Status for order: "+order.getId() + " --> "+status);
				}
			
				
				
		
			} catch (JMSException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
	}

	
}
