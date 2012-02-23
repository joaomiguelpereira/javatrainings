package eu.jpereira.trainings.jee.persistence;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObject;
import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObjectDAO;

@Stateless
public class DefaultExampleService implements ExampleService {

	private @EJB
	ExampleDomainObjectDAO dao;

	
	@Override
	public List<ExampleDomainObject> getAllExampleDomainObjects() {
		return dao.findAll();
	}


	@Override
	public ExampleDomainObject createExampleDomainObject(String string) {
		
		ExampleDomainObject domainObject = new ExampleDomainObject.Builder().withName(string).build();
		dao.create(domainObject);
		return domainObject;
	}

}
