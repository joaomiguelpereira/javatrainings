package eu.jpereira.trainings.jee.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An example Domain Object
 * 
 */
@Entity
public class ExampleDomainObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7626077607123448974L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static class Builder {

		private ExampleDomainObject builtObject;
		public Builder() {
			this.builtObject = new ExampleDomainObject();
		}
		public Builder withName(String name) {
			this.builtObject.setName(name);
			return this;
		}
		public ExampleDomainObject build() {
			
			return this.builtObject;
		}
		
	}

}
