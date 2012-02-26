package eu.jpereira.trainings.jee.persistence.model.store;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.trainings.jee.persistence.model.DomainObjectTest;
import eu.jpereira.trainings.jee.persistence.model.builder.BuilderRequiredValue;
import eu.jpereira.trainings.jee.persistence.model.common.PostalAddress;
import eu.jpereira.trainings.jee.persistence.model.customer.Customer;
import eu.jpereira.trainings.jee.persistence.model.customer.WebCustomer;
import eu.jpereira.trainings.jee.persistence.model.store.Department;
import eu.jpereira.trainings.jee.persistence.model.store.Store;

/**
 * Unit test for ExampleDomainObject
 */

public class StoreTest extends DomainObjectTest<Store> {

	@Before
	public void testEnvironmentSetup() {
		// Count the number of objects of type parameterized type in the
		// persistence context

		assertEntitySize(0);
	}

	@Test
	public void testPersitStore() {
		// Create a dummy domain object
		Store domainObject = new Store.Builder().withName(
				"My First Store in the system").build();
		// Open a transaction
		beginTx();
		em.persist(domainObject);
		// Commit the transaction
		commitTx();

		// Assert something was persisted
		assertEntitySize(1);

		// List for visual inspection
		List<Store> objects = gettAll();
		for (Store domain : objects) {
			System.out.println(domain.getName());
		}
	}

	@Test
	public void testListAllStores() throws BuilderRequiredValue {
		// Will ask the framework to create 5 dummy objects
		beginTx();
		persistDummyObjects(5);
		commitTx();
		List<Store> stores = gettAll();
		assertEquals(5, stores.size());
		// Print, for visual inspection
		for (Store store : stores) {
			System.err.println(store.getName());
		}
	}

	@Test
	public void testAddDepartmentToStore() {
		Department department = new Department.Builder().withName(
				"New department").build();
		// Create a dummy store
		Store testStore = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(testStore);
		testStore.addDepartment(department);
		commitTx();

		Long storeId = testStore.getId();
		// now, let's check if the
		Store persistedStore = find(storeId);
		assertEquals(1, persistedStore.getAllDepartments().size());
		
		//Check the the department has the correct reference to the store
		assertEquals(persistedStore, persistedStore.getAllDepartments().get(0).getStore());
	}

	@Test
	public void testRemoveDepartmentToStore() {
		Department department = new Department.Builder().withName(
				"New department").build();
		// Create a dummy store
		Store testStore = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(testStore);
		testStore.addDepartment(department);
		commitTx();
		assertEquals(testStore, department.getStore());
		Long storeId = testStore.getId();

		
		Store persistedStore = find(storeId);
		assertEquals(1, persistedStore.getAllDepartments().size());
 
		beginTx();
		persistedStore.removeDepartment(persistedStore.getAllDepartments().get(
				0));
		commitTx();
		persistedStore = find(storeId);
		assertEquals(0, persistedStore.getAllDepartments().size());
		assertNull(department.getStore());
	}

	@Test
	public void addCustomerToStore() throws BuilderRequiredValue {
		//Create a polymorphic Customer
		Customer customer = new WebCustomer.Builder()
				.withEmail("someemseail@email").withFirstName("First Name")
				.withLastName("Last Name").build();
		
		// The customer can exist alone
		beginTx();
		em.persist(customer);
		commitTx();

		Store testStore = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(testStore);
		commitTx();

		beginTx();
		Store persistedStore = find(testStore.getId());
		persistedStore.addCustomer(customer);

		commitTx();

		// Get the store
		persistedStore = find(testStore.getId());
		assertEquals(1, persistedStore.getAllCustomers().size());
	}

	@Test
	public void removeCustomer() throws BuilderRequiredValue {
		//Polymorphic customer
		Customer customer = new WebCustomer.Builder().withEmail("other@email")
				.withFirstName("First Name").withLastName("Last Name").build();
		// The customer can exist alone
		beginTx();
		em.persist(customer);
		commitTx();

		Store testStore = createDummyObjectWithSerialNumber(0);
		beginTx();
		em.persist(testStore);
		commitTx();

		beginTx();
		Store persistedStore = find(testStore.getId());
		persistedStore.addCustomer(customer);
		commitTx();

		// Get the store
		persistedStore = find(testStore.getId());
		assertEquals(1, persistedStore.getAllCustomers().size());

		beginTx();
		persistedStore.removeCustomer(persistedStore.getAllCustomers().get(0));

		commitTx();
		assertEquals(0, persistedStore.getAllCustomers().size());

	}

	@Override
	protected Store createDummyObjectWithSerialNumber(int i) {
		String name = new StringBuilder().append("Some dummy object ")
				.append(i).toString();
		
		PostalAddress address = new PostalAddress.Builder()
				.withCity("Some city").withPostalCode("Some postal code")
				.withStreet("Some Street").build();
		
		return new Store.Builder().withName(name).withPostalAddress(address)
				.build();

	}

}
