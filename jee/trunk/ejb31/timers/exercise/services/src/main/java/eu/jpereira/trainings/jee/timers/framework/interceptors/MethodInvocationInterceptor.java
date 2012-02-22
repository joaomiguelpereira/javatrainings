package eu.jpereira.trainings.jee.timers.framework.interceptors;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import eu.jpereira.trainings.jee.timers.service.TimeoutCounter;

public class MethodInvocationInterceptor {

	private @EJB
	TimeoutCounter timeoutCounter;

	@AroundInvoke
	public Object logClassCount(InvocationContext ic) throws Exception {
		System.out.println("Intecepting for: " + ic.getMethod().getDeclaringClass().getName());

		timeoutCounter.countTimeoutFor(ic.getMethod().getDeclaringClass());

		return ic.proceed();

	}
}
