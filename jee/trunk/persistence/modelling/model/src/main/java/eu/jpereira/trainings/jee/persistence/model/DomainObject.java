package eu.jpereira.trainings.jee.persistence.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * This is the base class for all Domain Objects in the App
 * 
 * @author jee
 * 
 */
@MappedSuperclass
public abstract class DomainObject {
	//Add any common state and behavior here
	
	@Version
	private Long version;
}
