package eu.jpereira.trainings.jee.persistence.model;


/**
 * The BasicDomain Object is the type for any domain object that is identified
 * by an id
 * 
 * @author jee
 * 
 */
// TODO Persistence: The state of this class should be persisted in every class
// down in the hierarchy. Annotate the class with proper javax.persistence
// annotation to tell persistence provider this is a mapped super class
public abstract class BasicDomainObject extends DomainObject {

	// TODO Persistence: The instance field id should be used by persistence
	// provided to identify persistence objects. This field should be mapped to
	// primary key in the relational model.
	// The value should be generated and set by the persistence provider using
	// AUTO strategy.
	// TODO: Annotate the field with the proper javax.persistenc annotation to
	// indicate this is the identifier of the persisted object (primary key in
	// db)
	// TODO: Annotate the field with javax.persistence.GeneratedValue and set
	// the strategy to GenerationType.AUTO
	
	
	private Long id;

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (other instanceof BasicDomainObject) {
			// If id is null, there's no way to compare the objects
			if (this.id == null || ((BasicDomainObject) other).id == null) {
				return this == other;
			}
			if (this.id.equals(((BasicDomainObject) other).id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return id.hashCode() * 32;
		} else {
			return super.hashCode();
		}
	}
}
