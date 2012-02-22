package eu.jpereira.trainings.jee.timers.service;

import javax.ejb.Remote;

@Remote
public interface TimeoutCounterFacade {

	/**
	 * Get the number of times a callback was called, where callback is from
	 * type of the class passed as parameter
	 * 
	 * @param classImplementingTimeout
	 * @return
	 */
	Integer getTimeoutCountFor(Class<?> classImplementingTimeout);

}
