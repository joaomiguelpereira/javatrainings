package eu.jpereira.trainings.jee6.cdi.interceptors.beans;

import eu.jpereira.trainings.jee6.cdi.interceptors.bindings.LoggedParameters;

public class LotteryService {

	@LoggedParameters
	public void sendPrizeTo(String name) {
		System.out.println("Sending prize to: "+name);
		
	}
}
