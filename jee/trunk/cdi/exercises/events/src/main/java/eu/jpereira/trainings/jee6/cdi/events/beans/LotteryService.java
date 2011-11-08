package eu.jpereira.trainings.jee6.cdi.events.beans;

import eu.jpereira.trainings.jee6.cdi.events.stereotypes.LoggedFull;

@LoggedFull
public class LotteryService {
	
	public void sendPrizeTo(String name) {
		System.out.println("Sending prize to: " + name);

	}
}
