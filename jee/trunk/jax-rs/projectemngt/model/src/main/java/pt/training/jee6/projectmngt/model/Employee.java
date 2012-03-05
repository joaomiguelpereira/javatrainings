package pt.training.jee6.projectmngt.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@Entity
public class Employee extends ApplicationEntity {

	private String name;

	@Temporal(TemporalType.DATE)
	private Date bornDate;

	@ManyToMany
	private Collection<Project> projects;
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

}
