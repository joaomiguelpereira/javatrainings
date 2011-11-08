package eu.jpereira.trainings.jee6.cdi.events.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedElapsedTime;


@Interceptor
@LoggedElapsedTime
@SuppressWarnings("unused")
public class LoggedElapsedTimeInterceptor {

	@AroundInvoke
	private Object logElapsedTime(InvocationContext ic) throws Exception {
		
		System.out
				.println("Entering method: " + ic.getMethod().getName()
						+ " from class "
						+ ic.getMethod().getDeclaringClass().getName());
		long startNanoTime = System.nanoTime();
		try {
			Object result = ic.proceed();
			System.out.println("Exiting method: " + ic.getMethod().getName()
					+ " from class "
					+ ic.getMethod().getDeclaringClass().getName() + " in "
					+ (System.nanoTime() - startNanoTime) + " nanoseconds");
			return result;
		} catch (Exception e) {
			System.out.println("Throwing exception from method: "
					+ ic.getMethod().getName() + " from class "
					+ ic.getMethod().getDeclaringClass().getName() + " in "
					+ (System.nanoTime() - startNanoTime) + " nanoseconds");
			throw e;
		}

	}
}
