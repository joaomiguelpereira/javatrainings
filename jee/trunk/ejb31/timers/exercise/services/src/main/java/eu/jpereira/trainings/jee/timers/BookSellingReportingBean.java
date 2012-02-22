package eu.jpereira.trainings.jee.timers;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;

/**
 * This singleton session bean will be instantiated once the application is
 * deployed. The post construct method will create a programmed timer. Look for
 * the TODOs:
 * 
 * @author jee
 * 
 */
@Singleton
@Startup
public class BookSellingReportingBean {

	// The SessionContext is required to obtain a reference to the timer service
	// of the container
	//TODO: Inject the Session context using the javax.annotation.Resource annotation
	
	//private SessionContext ctx;

	
	// The following injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model or service layer.That's why the spec disallow interceptors in timeout
	// methods, to reinforce this design.
	
	//TODO: Inject an EJB reference to this class using the annotation javax.ejb.EJB
	
	//private BookSellingReportingBean delegate;

	
	
	// TODO: This is the method that should run when timer expires. After
	// completing TODOs in the next method, don't forget to indicate that this
	// method is the timeout method using the annotation javax.ejb.Timeout
	public void runReport(Timer timer) {

		// This is the point where a delegation to domain model or service layer should occur
		// In this exercise, we're just delegating to a session bean of the same
		// type as this. In good design, you should avoid this
		// TODO: Delegate to an instance of this but with EJB services. This instance is client of an instance of same type
		//delegate.doJob();
	}

	
	//This is the method that will be intercepted by MethodInvocationIntercepto to count the number of times the method was invoked
	//TODO: Use the annotation javax.interceptor.Interceptors to specify the MethodInvocationInterceptor.class as an interceptor
	
	public void doJob() {
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		// TODO: 1 Create a new ScheduleExpression and configure it to run every
		// minute of every hour
		//Example: 
		
		//ScheduleExpression sExpression = new ScheduleExpression().minute("*") .hour("*");

		// TODO: 2 Create a new TimerConfig to configure the attribute of the
		// timer you will create
		
		TimerConfig timerConfig = new TimerConfig();

		// TODO: 3 Set the timer as not persistent, through the TimerConfig
		// instance created in previous step
		timerConfig.setPersistent(false);

		// TODO: 4 Using the injected SessionContext instance, get the calendar service and
		// create a
		// new calendar timer, passing it the created ScheduleExpression and
		// TimerConfig
		
		//createCalendarTimer(sExpression, timerConfig);

	}
}
