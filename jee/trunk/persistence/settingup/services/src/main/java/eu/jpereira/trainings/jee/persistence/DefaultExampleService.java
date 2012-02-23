package eu.jpereira.trainings.jee.persistence;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObject;
import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObjectGateway;

@Stateless
public class DefaultExampleService implements ExampleService {

	private @EJB
	ExampleDomainObjectGateway gateway;

	
	@Override
	public List<ExampleDomainObject> getAllExampleDomainObjects() {
		return gateway.findAll();
	}

}
