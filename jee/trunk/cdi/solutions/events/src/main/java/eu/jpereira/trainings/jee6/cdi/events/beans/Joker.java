package eu.jpereira.trainings.jee6.cdi.events.beans;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.events.events.LotteryResult;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EvenJokerResultGenerated;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.JokerLottery;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.RandomNumber;



/**
 * This implementation give a joker like number (7 digits)
 * @author jee5
 *
 */
@JokerLottery
public class Joker extends BaseLottery{

	private @Inject @RandomNumber(min=1000000, max=9999999) Integer randomNumber;
	
	private @Inject @EvenJokerResultGenerated Event<LotteryResult> evenJokerResultGeneratedEvent;
	
	@Override
	@LoggedElapsedTime
	public void generateResult() {
		System.out.println("Generating result for JOKER....");
		this.result = randomNumber.toString();
		if ( randomNumber%2 == 0) {
			
			this.evenJokerResultGeneratedEvent.fire(new LotteryResult(this.result));
		}
	}

}
