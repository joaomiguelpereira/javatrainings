package eu.jpereira.trainings.jee6.cdi.interceptors.beans;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.interceptors.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.RandomString;
import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.StringKeyLottery;


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
