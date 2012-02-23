package eu.jpereira.trainings.jee.persistence;

import java.util.List;

import javax.ejb.Remote;

import eu.jpereira.trainings.jee.persistence.model.ExampleDomainObject;

@Remote
public interface ExampleService {

	/**
	 * Return a list of all persisted objects
	 * @return
	 */
	List<ExampleDomainObject> getAllExampleDomainObjects();

	ExampleDomainObject createExampleDomainObject(String string);
}
