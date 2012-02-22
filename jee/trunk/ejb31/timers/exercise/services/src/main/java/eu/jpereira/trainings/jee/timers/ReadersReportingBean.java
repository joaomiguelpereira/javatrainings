package eu.jpereira.trainings.jee.timers;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerConfig;

/**
 * This is a singleton session bean that is instantiated at startup. It's also a
 * TimedObject. This demonstrates how to use of timer service with interface
 * javax.ejb.TimedObject
 * The post-create method should create a new timer that expires every 15 seconds
 * 
 * @author jee
 * 
 */
@Singleton
@Startup
// TODO: This class should be of type javax.ejb.TimedObject. 
// In theimplementation of method ejbTimeout from TimedObject, call delegate.doJob()
public class ReadersReportingBean {

	
	// The SessionContext is required to obtain a reference to the timer service
	// of the container and configure the times
	//TODO: Inject the Session context using the javax.annotation.Resource annotation
		
	//private SessionContext ctx;
	
	
	// The follwing injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model or service layer.That's why the spec disallow interceptors in timeout
	// methods, to reinforce
	// this design.
	
	//TODO: Inject an EJB reference to this class using the annotation javax.ejb.EJB
	//private ReadersReportingBean delegate;

	//TODO: Override the ejbTimout interface from javax.ejb.TimedObject
	/*@Override
	public void ejbTimeout(Timer timer) {
		delegate.doJob();
	}*/
	
	
	//This is the method that will be intercepted by MethodInvocationIntercepto to count the number of times the method was invoked
	//TODO: Use the annotation javax.interceptor.Interceptors to specify the MethodInvocationInterceptor.class as an interceptor
	public void doJob() {

	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {

		// TODO: 1 Create a new ScheduleExpression and configure it to run every
		// 15 seconds
		
		//sExpression = new ScheduleExpression().second("*/15").minute("*").hour("*");

		// TODO: 2 Create a new TimerConfig to configure the attribute of the
		// timer you will create
		TimerConfig timerConfig = new TimerConfig();

		// TODO: 3 Set the timer as not persistent, through the TimerConfig
		// instance created in previous step
		timerConfig.setPersistent(false);

		// TODO: 4 Using the injected SessionContext instance, get the calendar service and
		// create a new calendar timer, passing it the created ScheduleExpression and
		// TimerConfig
		
		//createCalendarTimer(sExpression, timerConfig);
	}

}
