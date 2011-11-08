package eu.jpereira.trainings.jee6.cdi.stereotypes.beans;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.stereotypes.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.stereotypes.qualifiers.RandomString;
import eu.jpereira.trainings.jee6.cdi.stereotypes.qualifiers.StringKeyLottery;


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
