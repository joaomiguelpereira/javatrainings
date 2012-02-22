package eu.jpereira.trainings.jee.timers.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * This is a singleton Session Bean that maintains the number of times a given
 * class run a timeout method
 * 
 * @author jee
 * 
 */
@Singleton
@Startup
@Lock(LockType.READ)
public class TimeoutCounter {

	// The key in the map is the class with the timeout
	// method
	// The value in the map is the number of times the class in the key has run
	// the timeout method
	private Map<Class<?>, Integer> reportRuns = new HashMap<Class<?>, Integer>();

	/**
	 * Every time a timeout expires, must call this method to record the times
	 * the timeout has expired
	 * 
	 * @param classWithTimeoutMethod
	 */
	@Lock(LockType.WRITE)
	public void countTimeoutFor(Class<?> classWithTimeoutMethod) {

		Integer currentRuns = this.reportRuns.get(classWithTimeoutMethod);

		if (currentRuns == null) {
			currentRuns = Integer.valueOf(0);

		}
		currentRuns++;
		this.reportRuns.put(classWithTimeoutMethod, currentRuns);
	}

	/**
	 * Call this method, passing it the class defining the timeout method, to
	 * see how many times the method has been called.
	 * 
	 * @param classToQuery
	 * @return
	 */
	public Integer getTimeoutCountFor(Class<?> classToQuery) {
		return this.reportRuns.get(classToQuery) != null ? this.reportRuns
				.get(classToQuery) : 0;
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void initializeComponent() {
		System.out.println("Initializing report generator...");
		this.reportRuns = new HashMap<Class<?>, Integer>();
	}

}
