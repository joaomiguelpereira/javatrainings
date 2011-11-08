package eu.jpereira.trainings.jee6.cdi.stereotypes.beans;

import eu.jpereira.trainings.jee6.cdi.stereotypes.bindings.LoggedParameters;

public class LotteryService {

	@LoggedParameters
	public void sendPrizeTo(String name) {
		System.out.println("Sending prize to: "+name);
		
	}
}
