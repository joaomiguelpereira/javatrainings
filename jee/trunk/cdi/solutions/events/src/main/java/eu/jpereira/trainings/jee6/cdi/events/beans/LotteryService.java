package eu.jpereira.trainings.jee6.cdi.events.beans;

import javax.enterprise.event.Observes;

import eu.jpereira.trainings.jee6.cdi.events.events.LotteryResult;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EuroMillionWithEvenStars;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EuroMillionWithOddStars;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EvenJokerResultGenerated;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.ResultAvaiable;





public class LotteryService {
	
	public void sendPrizeTo(String name) {
		System.out.println("Sending prize to: " + name);
	}
	
	@SuppressWarnings("unused")
	private void onEvenStartsGenerated(@Observes @EuroMillionWithEvenStars LotteryResult result) {
		System.out.println("I got two even starts: "+result.getResult());
	}
	
	@SuppressWarnings("unused")
	private void onOddStartsGenerated(@Observes @EuroMillionWithOddStars LotteryResult result) {
		System.out.println("I got two odd starts: "+result.getResult());
	}
	
	@SuppressWarnings("unused")
	private void onResultGenerated(@Observes @ResultAvaiable LotteryResult result) {
		System.out.println("OnResultGenerated: "+result.getResult());
	}
	
	@SuppressWarnings("unused")
	private void onEvenJokerResultGenerated(@Observes @EvenJokerResultGenerated LotteryResult result) {
		System.out.println("onEvenJokerResultGenerated: "+result.getResult());
	}
}
