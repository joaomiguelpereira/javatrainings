package eu.jpereira.trainings.jee6.cdi.producers.beans;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.JokerLottery;
import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.RandomNumber;



@JokerLottery
public class Joker extends AbstractLottery{
	
	private @Inject @RandomNumber(min=1000000, max=9999999) Integer randomNumber;
	
	@Override
	public void generateResult() {
		System.out.println("Generating Joker key...");	
		this.result = ""+this.randomNumber;
	}
}
