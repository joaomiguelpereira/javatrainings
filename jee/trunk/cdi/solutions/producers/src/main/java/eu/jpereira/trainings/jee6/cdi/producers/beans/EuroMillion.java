package eu.jpereira.trainings.jee6.cdi.producers.beans;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.EuroMillionLottery;
import eu.jpereira.trainings.jee6.cdi.producers.qualifiers.IntegerSequenceList;


@EuroMillionLottery
public class EuroMillion extends AbstractLottery {

	private @Inject
	@IntegerSequenceList(max = 50)
	List<Integer> numbers;
	private @Inject
	@IntegerSequenceList(max = 10)
	List<Integer> stars;

	private Random randomGenerator = new Random();

	@Override
	public void generateResult() {
		System.out.println("Generating Euro Million key...");
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
			result.append("{");
			result.append(getRandomElement(stars));
			result.append("} ");
		}

		this.result = result.toString();

	}

	private Integer getRandomElement(List<Integer> list) {
		// get some random index
		int rndIndex = randomGenerator.nextInt(list.size());
		Integer result = list.get(rndIndex);

		list.remove(rndIndex);
		return result;
	}

}
