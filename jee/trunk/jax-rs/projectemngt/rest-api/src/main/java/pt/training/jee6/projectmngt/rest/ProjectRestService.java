package pt.training.jee6.projectmngt.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pt.training.jee6.projectmngt.exception.ApplicationException;
import pt.training.jee6.projectmngt.model.Document;
import pt.training.jee6.projectmngt.model.Project;
import pt.training.jee6.projectmngt.rest.resource.DocumentResource;
import pt.training.jee6.projectmngt.rest.resource.ProjectDocumentListing;
import pt.training.jee6.projectmngt.rest.resource.ProjectListing;
import pt.training.jee6.projectmngt.rest.resource.ProjectResource;
import pt.training.jee6.projectmngt.rest.util.ServiceLocator;
import pt.training.jee6.projectmngt.service.ProjectService;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@Path("/projects")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
public class ProjectRestService extends AbstractRestService {

	// No injection in JAX-RS, maybe in a near future
	private ProjectService projectService = ServiceLocator.getInstance()
			.getService(ProjectService.class);

	@GET
	@Path("/projects")
	public Response getProjects() {
		Response serviceResponse = null;
		try {
			serviceResponse = responseOk(new ProjectListing(
					projectService.findAll()));
		} catch (ApplicationException e) {
			serviceResponse = error(e, null);
		}
		return serviceResponse;
	}

	@GET
	@Path("/{id}")
	public Response findProject(@PathParam("id") Long id) {
		Response serviceResponse = null;

		try {
			Project project = null;
			project = projectService.findById(id);
			if (project == null) {
				serviceResponse = notFound();
			} else {
				serviceResponse = responseOk(new ProjectResource(project));
			}

		} catch (ApplicationException e) {
			serviceResponse = error(e, null);
		}
		return serviceResponse;
	}

	@POST
	@Path("/projects")
	public Response createProject(ProjectResource projectResource) {
		Project project = projectResource.toProject();
		Response serviceResponse = null;
		try {
			Project createdProject = projectService.create(project);
			serviceResponse = responseOk(new ProjectResource(createdProject));
		} catch (Exception e) {
			serviceResponse = error(e);
		}
		return serviceResponse;
	}

	@PUT
	@Path("/{id}")
	public Response updateProject(ProjectResource projectResource,
			@PathParam("id") Long id) {
		Response serviceResponse = null;
		try {
			Project project = projectResource.toProject();
			project.setId(id);
			serviceResponse = responseOk(new ProjectResource(
					projectService.update(project)));
		} catch (Exception e) {
			serviceResponse = error(e);

		}
		return serviceResponse;
	}

	@DELETE
	@Path("/{id}")
	public Response removeProject(@PathParam("id") Long id) {
		Response serviceResponse = null;
		try {
			projectService.remove(id);
			serviceResponse = responseOk("Project deleted");
		} catch (Exception e) {
			serviceResponse = error(e);
		}
		return serviceResponse;
	}

	/** Docuemtns ***/
	@GET
	@Path("{id}/documents")
	public Response getDocuments(@PathParam("id") Long id) {
		Response serviceResponse = null;
		try {
			serviceResponse = responseOk(new ProjectDocumentListing(
					projectService.getDocuments(id)));
		} catch (Exception e) {
			serviceResponse = error(e);
		}
		return serviceResponse;
	}

	@POST
	@Path("{id}/documents")
	public Response createDocument(@PathParam("id") Long id,
			DocumentResource documentResource) {
		Response serviceResponse = null;

		try {
			serviceResponse = responseOk(new DocumentResource(
					projectService.createDocument(id,
							documentResource.toDocument())));
		} catch (ApplicationException e) {
			serviceResponse = error(e);
		}
		return serviceResponse;
	}

	@GET
	@Path("{id}/documents/{doc_id}")
	public Response getDocument(@PathParam("id") Long projectId,
			@PathParam("doc_id") Long documentId) {
		Response serviceResponse = null;
		try {
			serviceResponse = responseOk(new DocumentResource(
					projectService.findDocument(projectId, documentId)));
		} catch (ApplicationException e) {
			serviceResponse = error(e);
		}
		return serviceResponse;
	}

	@PUT
	@Path("{id}/documents/{doc_id}")
	public Response updateDocument(@PathParam("id") Long projectId,
			@PathParam("doc_id") Long documentId,
			DocumentResource documentResource) {
		Response serviceResponse = null;

		try {
			Document document = documentResource.toDocument();
			document.setId(documentId);
			serviceResponse = responseOk(new DocumentResource(
					projectService.updateDocument(projectId, document)));
		} catch (ApplicationException e) {
			serviceResponse = error(e);
		}

		return serviceResponse;
	}

	@DELETE
	@Path("{id}/documents/{doc_id}")
	public Response removeDocument(@PathParam("id") Long projectId,
			@PathParam("doc_id") Long documentId) {
		Response serviceResponse = responseOk("Document deleted!");

		try {
			projectService.removeDocument(projectId, documentId);
		} catch (ApplicationException e) {
			serviceResponse = error(e);
		}
		return serviceResponse;

	}

}
