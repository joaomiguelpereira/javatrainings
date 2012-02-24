package eu.jpereira.trainings.jee.persistence.model;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

@Ignore
public abstract class PersistenceTest {

	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random rnd = new Random();

	@Ignore
	protected String getRandomString(int maxSize) {
		StringBuilder sb = new StringBuilder(maxSize);
		for (int i = 0; i < maxSize; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}

	/**
	 * Will create a new static EntityManager for the persistence unit
	 */
	@BeforeClass
	public static void initiTestCase() {
		emf = Persistence.createEntityManagerFactory(TestConfigurator.instance
				.getPersistenceUnitName());
		em = emf.createEntityManager();
	}

	/**
	 * Shutdow entitymanager and entitymanager factory
	 */
	@AfterClass
	public static void shutDown() {
		if (em != null)
			em.close();

		if (emf != null)
			emf.close();

	}

	@Before
	public void reset() throws Exception {
		TestConfigurator.instance.getTestDbHelper().clearDatabase();

	}

	@Ignore
	protected String getRandomString(String prefix, int max) {
		return prefix + "_" + getRandomString(max);
	}

	/**
	 * Open a transaction
	 */
	@Ignore
	protected void beginTx() {
		em.getTransaction().begin();
	}

	/**
	 * Commit a transaction
	 */
	@Ignore
	protected void commitTx() {
		em.getTransaction().commit();
	}

}
