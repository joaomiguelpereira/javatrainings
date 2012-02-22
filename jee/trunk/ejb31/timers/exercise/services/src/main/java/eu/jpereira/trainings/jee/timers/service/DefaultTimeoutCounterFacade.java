package eu.jpereira.trainings.jee.timers.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class DefaultTimeoutCounterFacade implements TimeoutCounterFacade {

	private @EJB
	TimeoutCounter timeoutCounter;

	@Override
	public Integer getTimeoutCountFor(Class<?> classImplementingTimeout) {

		return this.timeoutCounter.getTimeoutCountFor(classImplementingTimeout);
	}

}
