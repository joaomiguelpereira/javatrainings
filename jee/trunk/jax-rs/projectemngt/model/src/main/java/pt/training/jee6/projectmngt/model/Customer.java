package pt.training.jee6.projectmngt.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@Entity
public class Customer extends ApplicationEntity {
	
	
	private String name;
	@OneToMany(mappedBy="customer")
	private Collection<Project> projects;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	public Collection<Project> getProjects() {
		return projects;
	}
	

}
