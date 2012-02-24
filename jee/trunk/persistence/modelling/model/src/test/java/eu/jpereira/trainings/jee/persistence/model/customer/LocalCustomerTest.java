package eu.jpereira.trainings.jee.persistence.model.customer;

import org.junit.Test;

import eu.jpereira.trainings.jee.persistence.model.DomainObjectTest;
import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;

public class LocalCustomerTest extends DomainObjectTest<LocalCustomer> {
	
	
	
	@Test
	public void testCreate() throws BuilderRequiredValue {
		LocalCustomer lCustomer = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(lCustomer);
		commitTx();
		assertEntitySize(1);
	}

	@Override
	protected LocalCustomer createDummyObjectWithSerialNumber(int i)
			throws BuilderRequiredValue {

		LocalCustomer lCustomer = new LocalCustomer.Builder()
				.withCardNumber("1200")
				.withFirstName("Test first Name")
				.withLastName("Some Last Name")
				.withPostalAddress(
						new PostalAddress.Builder().withCity("Aveiro")
								.withPostalCode("Postal Code")
								.withStreet("Street").build()).build();

		return lCustomer;
	}
}
