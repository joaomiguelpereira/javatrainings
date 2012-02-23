package eu.jpereira.trainings.jee.persistence.model;

import org.junit.Before;
import org.junit.Test;
/**
 * Unit test for ExampleDomainObject
 */

public class ExampleDomainObjectTest extends PersistenceTest{

	
	@Before
	public void testEnvironmentSetup() {
		// Count the number of objects of type ExampleDomainObject in the
		// persistence context
		assertEntitySize(0, ExampleDomainObject.class);
	}

	@Test
	public void testPersitDomainObject() {
		// Create a dummy domain object
		ExampleDomainObject domainObject = new ExampleDomainObject();		
		beginTx();
		em.persist(domainObject);
		commitTx();
		assertEntitySize(1, ExampleDomainObject.class);
	}

}
