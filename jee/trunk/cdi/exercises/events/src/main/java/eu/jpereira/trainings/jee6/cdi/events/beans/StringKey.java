package eu.jpereira.trainings.jee6.cdi.events.beans;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.RandomString;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.StringKeyLottery;


@StringKeyLottery
public class StringKey extends BaseLottery {

	
	private @Inject @RandomString String randomKey;
	@Override
	@LoggedElapsedTime
	public void generateResult() {
		System.out.println("Generating random String....");
		this.result = randomKey;
		
	}

}
