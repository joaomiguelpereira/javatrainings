package eu.jpereira.trainings.jee.persistence.model.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.trainings.jee.persistence.model.DomainObjectTest;
import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;
import eu.jpereira.trainings.jee.persistence.model.customer.WebCustomer;
import eu.jpereira.trainings.jee.persistence.model.items.EBookItem;
import eu.jpereira.trainings.jee.persistence.model.items.ItemDimensions;
import eu.jpereira.trainings.jee.persistence.model.items.PhysicalItem;
import eu.jpereira.trainings.jee.persistence.model.items.SellableItem;
import eu.jpereira.trainings.jee.persistence.model.items.SoftwareItem;

public class CartTest extends DomainObjectTest<Cart> {

	private WebCustomer testCustomer;

	@Before
	public void setupTestFisture() throws BuilderRequiredValue {
		this.testCustomer = new WebCustomer.Builder()
				.withEmail("Email")
				.withFirstName("First NAme")
				.withLastName("Last name")
				.withPostalAddress(
						new PostalAddress.Builder().withCity("city")
								.withPostalCode("Postal Code")
								.withStreet("Street").build()).build();
		beginTx();
		em.persist(testCustomer);
		commitTx();

		WebCustomer otherCostumer = em
				.createQuery("select c from WebCustomer c where c.email=?1", WebCustomer.class)
				.setParameter(1, "Email").getSingleResult();
		
		
		
	}

	@Test
	public void testAddItemToCart() {
		SoftwareItem softwareApp = createDummySoftwareItem();
		beginTx();
		// need first to persiste sellable item
		em.persist(softwareApp);
		testCustomer.getCart().addItem(softwareApp);
		commitTx();
		assertTrue(!testCustomer.getCart().isEmpty());
	}

	@Test
	public void testCalculateCartTotalCost() {

		List<SellableItem> createItems = new ArrayList<SellableItem>();

		for (int i = 0; i < 100; i++) {
			createItems.add(persist(createDummyEbookItem()));
			createItems.add(persist(createDummyPhysicalItem()));
			createItems.add(persist(createDummySoftwareItem()));
		}
		beginTx();
		this.testCustomer.getCart().addItems(createItems);
		commitTx();
		assertEquals(Float.valueOf(100 * 300), this.testCustomer.getCart()
				.calculatePrice());

	}

	@Test
	public void testClearCart() {
		// Create some items
		List<SellableItem> createItems = new ArrayList<SellableItem>();

		for (int i = 0; i < 100; i++) {
			createItems.add(persist(createDummyEbookItem()));
			createItems.add(persist(createDummyPhysicalItem()));
			createItems.add(persist(createDummySoftwareItem()));
		}

		// Add all to the customer cart
		beginTx();
		this.testCustomer.getCart().addItems(createItems);
		commitTx();
		assertEquals(300, this.testCustomer.getCart().itemCount());

		beginTx();
		testCustomer.getCart().empty();
		commitTx();
		assertTrue(testCustomer.getCart().isEmpty());

	}

	private SellableItem persist(SellableItem sellableItem) {
		beginTx();
		em.persist(sellableItem);
		commitTx();
		return sellableItem;
	}

	public SoftwareItem createDummySoftwareItem() {
		return new SoftwareItem.Builder().withActivationKey("ActivationKey")
				.withDownloadURL("Download URL")
				.withName(getRandomString("Software Item", 10))
				.withDescription("Some Description").withPrice(100f).build();

	}

	public EBookItem createDummyEbookItem() {
		return new EBookItem.Builder().withISBN("ISBN")
				.withDownloadURL("Download URL")
				.withName(getRandomString("Ebook", 10))
				.withDescription("Some Description").withPrice(100f).build();

	}

	public PhysicalItem createDummyPhysicalItem() {
		return new PhysicalItem.Builder()
				.withDimensions(
						new ItemDimensions.Builder().withHeight(200)
								.withWeigth(10).withWidth(222).buil())
				.withName(getRandomString("physical Item", 10))
				.withDescription("Description").withPrice(100f).build();

	}

	@Override
	protected Cart createDummyObjectWithSerialNumber(int i)
			throws BuilderRequiredValue {

		return new Cart();
	}

}
