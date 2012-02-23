package eu.jpereira.trainings.jee.persistence.test;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.jpereira.trainings.jee.persistence.DefaultExampleService;
import eu.jpereira.trainings.jee.persistence.ExampleService;
import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObject;

public class ExampleServiceTest extends RemoteEJBTest {

	@BeforeClass
	public static void setupEnv() {
		appName = "ear-1.0-SNAPSHOT";
		moduleName = "services-1.0-SNAPSHOT";

	}

	@Test
	public void getAllDomainObjects() throws NamingException {
		ExampleService service = getStatelessSessionBeanReferenceFor(
				ExampleService.class, DefaultExampleService.class);

		assertNotNull(service.getAllExampleDomainObjects());
	}
	

	@Test
	public void createDomainObject() throws NamingException {
		ExampleService service = getStatelessSessionBeanReferenceFor(
				ExampleService.class, DefaultExampleService.class);

		ExampleDomainObject domainObject = service.createExampleDomainObject("name goes here");
		assertNotNull(domainObject);
		assertNotNull(domainObject.getId());
		
		
		
	}

}
