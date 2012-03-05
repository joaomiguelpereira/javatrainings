package pt.training.jee6.projectmngt.rest;

import java.util.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import pt.training.jee6.projectmngt.rest.resource.ErrorDescription;
import pt.training.jee6.projectmngt.rest.resource.RestResource;

/**
 * @author joaomiguel.pereira@gmail.com
 */
public abstract class AbstractRestService {
	private static Logger LOG = Logger.getLogger(AbstractRestService.class
			.getName());

	protected void handleException(Throwable tr, Response.Status status) {
		LOG.severe("Error: " + tr.getMessage());
		tr.printStackTrace();
		throw new WebApplicationException(status);
	}

	protected Response notFound() {
		return response("Resource Not found", Response.Status.NOT_FOUND);

	}

	protected Response error(Throwable tr) {
		return response(tr.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
	}

	protected Response error(Throwable tr, Response.Status status) {

		return response(tr.getMessage(),
				status == null ? Response.Status.INTERNAL_SERVER_ERROR : status);
	}

	protected Response responseOk(RestResource resource) {
		return Response.ok(resource).build();
	}

	protected Response responseOk(String msg) {

		return response(msg, Response.Status.OK);
	}

	protected Response response(String msg, Response.Status status) {
		ErrorDescription errorDescription = new ErrorDescription();
		errorDescription.setMessage(msg);
		ResponseBuilder builder = Response.status(status);
		builder.entity(errorDescription);
		return builder.build();

	}
}
