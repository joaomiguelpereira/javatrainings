package eu.jpereira.trainings.jee.persistence.model.customer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import eu.jpereira.trainings.jee.persistence.model.DomainObjectTest;
import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;

public class WebCustomerTest extends DomainObjectTest<WebCustomer> {

	@Test
	public void testGetCustomerCart() {
		WebCustomer testCustomer = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(testCustomer);
		commitTx();
		assertEntitySize(1);

	}

	@Test
	public void testHasCart() {
		WebCustomer testCustomer = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(testCustomer);
		commitTx();
		assertEntitySize(1);
		assertNotNull(testCustomer.cart);
	}

	@Override
	protected WebCustomer createDummyObjectWithSerialNumber(int i) {
		WebCustomer customer = null;

		try {
			customer = new WebCustomer.Builder()
					.withEmail("email@email.com")
					.withFirstName("First Name")
					.withLastName("Last Name")
					.withPostalAddress(
							new PostalAddress.Builder().withCity("Aveiro")
									.withPostalCode("3810")
									.withStreet("The street").build()).build();
		} catch (BuilderRequiredValue e) {
			e.printStackTrace();
			throw new RuntimeException("Error while creating dummy Customer: "
					+ e.getMessage());
		}
		return customer;
	}

}
