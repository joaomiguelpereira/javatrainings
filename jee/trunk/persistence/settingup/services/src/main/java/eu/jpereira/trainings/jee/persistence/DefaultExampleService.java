package eu.jpereira.trainings.jee.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObject;

@Stateless
public class DefaultExampleService implements ExampleService {

	@PersistenceUnit
	private EntityManager em;

	@Override
	public List<ExampleDomainObject> getAllExampleDomainObjects() {

		return em.createNamedQuery("findAll", ExampleDomainObject.class)
				.getResultList();
	
		
	}

}
