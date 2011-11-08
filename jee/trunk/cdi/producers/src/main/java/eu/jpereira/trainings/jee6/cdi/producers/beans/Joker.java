package eu.jpereira.trainings.jee6.cdi.producers.beans;

import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.JokerLottery;

@JokerLottery
public class Joker extends AbstractLottery{
	@Override
	public void generateResult() {
		System.out.println("Generating Joker key...");
		
		this.result = "Are you serious??";
	}
}
