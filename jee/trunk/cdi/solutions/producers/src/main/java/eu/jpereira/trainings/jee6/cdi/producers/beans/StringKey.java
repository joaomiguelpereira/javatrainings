package eu.jpereira.trainings.jee6.cdi.producers.beans;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.RandomString;
import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.StringKeyLottery;


@StringKeyLottery
public class StringKey extends AbstractLottery {

	private @Inject @RandomString String randomString;
	@Override
	public void generateResult() {
		System.out.println("Generating a rando String key...");
		this.result = randomString;
		
	}

}
