package eu.jpereira.trainings.jee6.cdi.producers.beans;

import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.StringKeyLottery;

@StringKeyLottery
public class StringKey extends AbstractLottery {

	@Override
	public void generateResult() {
		System.out.println("Generating a rando String key...");
		this.result = "I don't feel I want to do that right now....";
		
	}

}
