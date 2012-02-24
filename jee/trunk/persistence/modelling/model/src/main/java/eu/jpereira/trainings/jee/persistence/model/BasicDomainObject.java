package eu.jpereira.trainings.jee.persistence.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasicDomainObject extends DomainObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// don'te have setter for id because is readonly. Persistence provide will
	// assign a unique ID
	private Long id;

	public Long getId() {
		return id;
	}

}
