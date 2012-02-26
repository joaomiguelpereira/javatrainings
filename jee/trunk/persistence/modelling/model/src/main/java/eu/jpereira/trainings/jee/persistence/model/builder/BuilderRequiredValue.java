package eu.jpereira.trainings.jee.persistence.model.builder;

/**
 * Commom exception for builder that need to validate the existence of a field
 * 
 * @author jee
 * 
 */
public class BuilderRequiredValue extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7727806261433233714L;

	public BuilderRequiredValue(String message) {
		super(message);
	}
}
