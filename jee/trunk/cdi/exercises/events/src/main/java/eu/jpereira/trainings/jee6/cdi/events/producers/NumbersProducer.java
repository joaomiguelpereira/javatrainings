package eu.jpereira.trainings.jee6.cdi.events.producers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import eu.jpereira.trainings.jee6.cdi.events.qualifiers.IntegerSequenceList;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.RandomNumber;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.RandomString;


@SuppressWarnings("unused")
public class NumbersProducer {

	private @Produces
	@RandomString
	String randomString = NumbersProducer.generateRandomString();
	

	/**
	 * Produces a random number
	 */
	private @Produces
	@RandomNumber
	Integer getRandomNumber(InjectionPoint ip) {
		int max = 50;
		int min = 0;
		RandomNumber rna = ip.getAnnotated().getAnnotation(RandomNumber.class);
		if (rna != null) {
			max = rna.max();
			min = rna.min();
		}
		if (max - min <= 0) {
			throw new RuntimeException(
					"@RandomNumber - The max number must be greater than the min number");
		}
		Random rndGenerator = new Random();
		return rndGenerator.nextInt(max - min) + min;
	}

	/**
	 * Produces a sequence of numbers
	 * 
	 * @param ip
	 * @return
	 */
	private @Produces
	@IntegerSequenceList
	List<Integer> getIntegerSequence(InjectionPoint ip) {
		int max = 50;
		List<Integer> producedList;
		// get the max from the used annotation
		IntegerSequenceList isl = ip.getAnnotated().getAnnotation(
				IntegerSequenceList.class);
		// Protect for null
		if (isl != null) {
			max = isl.max();
		}
		producedList = new ArrayList<Integer>(max);
		for (int i = 1; i <= max; i++) {
			producedList.add(i);
		}
		return producedList;
	}

	/**
	 * Generate a Random String
	 * @return
	 */
	private static String generateRandomString() {
		SecureRandom secRandom = new SecureRandom();
		return new BigInteger(130, secRandom).toString(32).toUpperCase();
	}

}
