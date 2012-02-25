package eu.jpereira.trainings.jee.persistence.model;

import org.junit.Ignore;

/**
 * Simple static information to configure the tests
 * 
 * @author jee
 * 
 */
@Ignore
public class TestConfigurator {

	// Has a default value for this project. For complete reuse, read it from a
	// properties file, for example
	private String persistenceUnitName = "testPU";

	private TestDBHelper testDBHelper = new HSQLHelper();
	public static TestConfigurator instance = new TestConfigurator();

	private TestConfigurator() {

	}

	public String getPersistenceUnitName() {
		return persistenceUnitName;
	}
	
	public TestDBHelper getTestDbHelper() {
		return this.testDBHelper;
	}

}
