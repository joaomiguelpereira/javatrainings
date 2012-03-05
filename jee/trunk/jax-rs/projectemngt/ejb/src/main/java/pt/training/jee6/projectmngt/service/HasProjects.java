package pt.training.jee6.projectmngt.service;

import java.util.Collection;

import pt.training.jee6.projectmngt.exception.ApplicationException;
import pt.training.jee6.projectmngt.model.Project;

/**
 * @author joaomiguel.pereira@gmail.com
 */
public interface HasProjects {
	
	public Collection<Project> getProjects(Long id) throws ApplicationException;
	public void addProject(Long id, Project project) throws ApplicationException;
	public void removeProject(Long id, Long projectId) throws ApplicationException;

}
