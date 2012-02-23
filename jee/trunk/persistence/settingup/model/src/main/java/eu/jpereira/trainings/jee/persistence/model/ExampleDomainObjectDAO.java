package eu.jpereira.trainings.jee.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExampleDomainObjectDAO {

	@PersistenceContext
	private EntityManager em;

	public List<ExampleDomainObject> findAll() {
		return new ArrayList<ExampleDomainObject>();
	}

	public void create(ExampleDomainObject domainObject) {
		em.persist(domainObject);
		
		
	}
}
