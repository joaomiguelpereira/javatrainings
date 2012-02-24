package eu.jpereira.trainings.jee.persistence.model.store;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.trainings.jee.persistence.model.DomainObjectTest;
import eu.jpereira.trainings.jee.persistence.model.items.ItemDimensions;
import eu.jpereira.trainings.jee.persistence.model.items.PhysicalItem;
import eu.jpereira.trainings.jee.persistence.model.items.SellableItem;
import eu.jpereira.trainings.jee.persistence.model.store.Department;

import static org.junit.Assert.*;

public class DepartmentTest extends DomainObjectTest<Department> {

	@Before
	public void testEnvironmentSetup() {
		// Count the number of objects of type parameterized type in the
		// persistence context
		assertEntitySize(0);
	}

	@Test
	public void testAddSellableItem() {
		Department department = createDummyObjectWithSerialNumber(0);

		PhysicalItem physicalItem = new PhysicalItem();
		physicalItem.setDescription("Some description");
		physicalItem.setName("Some name");
		physicalItem.setPrice(10.0f);
		ItemDimensions dimensions = new ItemDimensions();
		dimensions.setHeight(10);
		dimensions.setWeigth(20);
		dimensions.setWidth(30);
		physicalItem.setDimensions(dimensions);
		department.addSellableItem(physicalItem);

		beginTx();
		em.persist(department);
		commitTx();

		Department savedDepartment = find(department.getId());
		assertEquals(1, savedDepartment.getAllSellableItems().size());
	}

	@Test
	public void testRemoveSellableItem() {
		Department department = createDepartmentWithSomeSellableItems(10);
		Department savedDepartment = find(department.getId());

		assertEquals(10, savedDepartment.getAllSellableItems().size());
		SellableItem itemToRemove = savedDepartment.getAllSellableItems().get(0);
		department.removeSellableItem(itemToRemove);
		
		assertEquals(9, savedDepartment.getAllSellableItems().size());
		
		
	}
	
	private Department createDepartmentWithSomeSellableItems(int max) {
		Department department = createDummyObjectWithSerialNumber(0);

		for (int i=0; i< max; i++ ) {
			PhysicalItem physicalItem = new PhysicalItem();
			physicalItem.setDescription("Some description "+i);
			physicalItem.setName("Some name "+i);
			physicalItem.setPrice(10.0f);
			ItemDimensions dimensions = new ItemDimensions();
			dimensions.setHeight(10);
			dimensions.setWeigth(20);
			dimensions.setWidth(30);
			physicalItem.setDimensions(dimensions);
			department.addSellableItem(physicalItem);
		}
		beginTx();
		em.persist(department);
		commitTx();
		
		return department;
	}

	@Override
	protected Department createDummyObjectWithSerialNumber(int i) {
		return new Department.Builder().withName("Dept " + i).build();
	}

}
