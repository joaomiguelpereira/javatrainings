package pt.training.jee6.projectmngt.rest.resource;

import java.util.ArrayList;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pt.training.jee6.projectmngt.model.Project;
/**
 * @author joaomiguel.pereira@gmail.com
 */
@XmlRootElement(name="projects")
public class ProjectListing implements RestResource {

	private Collection<ProjectResource> projects;
	public ProjectListing() {
		
	}
	public ProjectListing(Collection<Project> projects) {
		//Transform this
		this.projects = new ArrayList<ProjectResource>();
		for (Project project: projects ) {
			this.projects.add(new ProjectResource(project));
		}
		
	}


	@XmlElement(name="project")
	public Collection<ProjectResource> getProjects() {
		return projects;
	}
	
}
