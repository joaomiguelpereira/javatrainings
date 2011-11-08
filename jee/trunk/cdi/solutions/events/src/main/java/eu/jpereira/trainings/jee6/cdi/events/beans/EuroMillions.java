package eu.jpereira.trainings.jee6.cdi.events.beans;

import java.util.List;
import java.util.Random;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.util.AnnotationLiteral;
import javax.enterprise.util.TypeLiteral;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.events.events.LotteryResult;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EuroMillionLottery;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EuroMillionWithEvenStars;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.EuroMillionWithOddStars;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.IntegerSequenceList;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.ResultAvaiable;

/**
 * This implementation gives an euro million like key
 * 
 * @author jee5
 * 
 */

@EuroMillionLottery
public class EuroMillions extends BaseLottery {

	private @Inject
	@IntegerSequenceList(max = 50)
	List<Integer> numbers;
	private @Inject
	@IntegerSequenceList(max = 10)
	List<Integer> stars;

	private @Inject Event<LotteryResult> lotteryResultEvent;

	private Random rndGenerator = new Random();

	
	@SuppressWarnings("serial")
	@Override
	@LoggedElapsedTime
	public void generateResult() {
		boolean evenStars[] = { false, false };
		System.out.println("Generating result for Eruro Million....");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			// get some random index
			result.append("[");
			result.append(getRandomElement(numbers));
			result.append("] ");

		}
		// Get stars
		for (int i = 0; i < 2; i++) {

			// get some random index
			int star = getRandomElement(stars);
			result.append("{");
			result.append(star);
			result.append("} ");
			evenStars[i] = (star % 2 == 0);

		}

		this.result = result.toString();
		if (evenStars[0] && evenStars[1]) {

			lotteryResultEvent.select(
					new AnnotationLiteral<EuroMillionWithEvenStars>() {
					}).fire(new LotteryResult(this.result));
		} else if (!evenStars[0] && !evenStars[1]) {
			lotteryResultEvent.select(
					new AnnotationLiteral<EuroMillionWithOddStars>() {

					}).fire(new LotteryResult(this.result));
		}

	}

	private Integer getRandomElement(List<Integer> list) {
		// get some random index
		int rndIndex = rndGenerator.nextInt(list.size());
		Integer result = list.get(rndIndex);

		list.remove(rndIndex);
		return result;
	}

}
