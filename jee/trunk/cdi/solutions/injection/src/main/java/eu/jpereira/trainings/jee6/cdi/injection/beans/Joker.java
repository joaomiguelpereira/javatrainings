package eu.jpereira.trainings.jee6.cdi.injection.beans;

import java.util.Random;

import eu.jpereira.trainings.jee6.cdi.injection.qualifiers.JokerLottery;


@JokerLottery
public class Joker extends AbstractLottery{
	@Override
	public void generateResult() {
		System.out.println("Generating Joker key...");
		//real Implementation will follow latter
		this.result = ""+new Random().nextInt(1000);
	}
}
