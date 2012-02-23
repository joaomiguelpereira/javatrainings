package eu.jpereira.trainings.jee.persistence.model;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ExampleDomainObjectGateway {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	public List<ExampleDomainObject> findAll() {
		return null;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void save() {
		
	}
	
	
	@Remove
	public void closeGate() {
		
	}
}
