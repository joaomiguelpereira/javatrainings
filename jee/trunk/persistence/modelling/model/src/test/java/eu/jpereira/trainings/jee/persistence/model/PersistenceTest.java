package eu.jpereira.trainings.jee.persistence.model;

import java.util.Random;

import org.junit.Ignore;

@Ignore
public class PersistenceTest {

	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random rnd = new Random();

	@Ignore
	protected String getRandomString(int maxSize) {
		StringBuilder sb = new StringBuilder( maxSize);
		   for( int i = 0; i < maxSize; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();

	}
	

	@Ignore
	protected String getRandomString(String prefix, int max) {
		return prefix+"_"+getRandomString(max);
	}

}
