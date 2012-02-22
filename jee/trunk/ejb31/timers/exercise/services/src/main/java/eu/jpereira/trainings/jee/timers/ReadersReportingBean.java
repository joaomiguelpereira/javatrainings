package eu.jpereira.trainings.jee.timers;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.ScheduleExpression;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.interceptor.Interceptors;

import eu.jpereira.trainings.jee.timers.framework.interceptors.MethodInvocationInterceptor;

/**
 * This is a singleton session bean that is instantiated at startup. It's also a
 * TimedObject. This demonstrates how to use of timer service with interface
 * TimedObject
 * 
 * @author jee
 * 
 */
@Singleton
@Startup
// TODO: This class should be of type javax.ejb.TimedObject. In the
// implementation of method ejbTimeout from TimedObject, call delegate.doJob()
public class ReadersReportingBean implements TimedObject {

	// Used to get the TimerService
	private @Resource
	SessionContext ctx;

	// this injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model.That's why the spec disallow interceptors in timeout
	// methods, to reinforce
	// this design.
	private @EJB
	ReadersReportingBean delegate;

	@Override
	public void ejbTimeout(Timer timer) {
		delegate.doJob();
	}

	@Interceptors(MethodInvocationInterceptor.class)
	public void doJob() {

	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {

		// TODO: 1 Create a new ScheduleExpression and configure it to run every
		// minute of every hour
		ScheduleExpression sExpression = new ScheduleExpression().minute("*")
				.hour("*");

		// TODO: 2 Create a new TimerConfig to configure the attribute of the
		// timer you will create
		TimerConfig timerConfig = new TimerConfig();

		// TODO: 3 Set the timer as not persistent, through the TimerConfig
		// instance created in previous step
		timerConfig.setPersistent(false);

		// TODO: 4 Using the instance field ctx, get the calendar service and
		// create a
		// new calendar timer, passing it the created ScheduleExpression and
		// TimerConfig
		this.ctx.getTimerService()
				.createCalendarTimer(sExpression, timerConfig);
	}

}
