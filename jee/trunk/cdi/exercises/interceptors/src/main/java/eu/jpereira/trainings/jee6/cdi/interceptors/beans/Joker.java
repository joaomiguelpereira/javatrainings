package eu.jpereira.trainings.jee6.cdi.interceptors.beans;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.JokerLottery;
import eu.jpereira.trainings.jee6.cdi.interceptors.qualifiers.RandomNumber;



/**
 * This implementation give a joker like number (7 digits)
 * @author jee5
 *
 */
@JokerLottery
public class Joker extends BaseLottery{

	private @Inject @RandomNumber(min=1000000, max=9999999) Integer randomNumber;
	
	
	@Override
	public void generateResult() {
		System.out.println("Generating result for JOKER....");
		this.result = randomNumber.toString();
	}

}
