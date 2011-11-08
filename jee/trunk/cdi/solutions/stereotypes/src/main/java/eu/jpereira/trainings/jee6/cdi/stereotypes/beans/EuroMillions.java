package eu.jpereira.trainings.jee6.cdi.stereotypes.beans;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.stereotypes.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.stereotypes.qualifiers.EuroMillionLottery;
import eu.jpereira.trainings.jee6.cdi.stereotypes.qualifiers.IntegerSequenceList;


/**
 * This implementation gives an euro million like key
 * @author jee5
 *
 */

@EuroMillionLottery

public class EuroMillions extends BaseLottery{

	private @Inject @IntegerSequenceList(max=50) List<Integer> numbers;
	private @Inject @IntegerSequenceList(max=10) List<Integer> stars;
	
	
	private Random rndGenerator = new Random();
	
	
	
	@Override
	@LoggedElapsedTime
	public void generateResult() {
		System.out.println("Generating result for Eruro Million....");
		StringBuilder result = new StringBuilder();
		for (int i=0; i< 5; i++) {
			//get some random index
			result.append("[");
			result.append(getRandomElement(numbers));
			result.append("] ");
			
		}
		//Get stars
		for (int i=0; i< 2; i++) {
			//get some random index
			result.append("{");
			result.append(getRandomElement(stars));
			result.append("} ");
		}
		
		this.result = result.toString();
	}
	
	
	private Integer getRandomElement(List<Integer> list) {
		//get some random index
		int rndIndex = rndGenerator.nextInt(list.size());
		Integer result = list.get(rndIndex);
		
		list.remove(rndIndex);
		return result;
	}
	
	

}
