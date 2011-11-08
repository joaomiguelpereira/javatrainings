package eu.jpereira.trainings.jee6.cdi.stereotypes.beans;

import eu.jpereira.trainings.jee6.cdi.stereotypes.stereotypes.LoggedFull;

@LoggedFull
public class LotteryService {

	
	public void sendPrizeTo(String name) {
		System.out.println("Sending prize to: " + name);

	}
}
