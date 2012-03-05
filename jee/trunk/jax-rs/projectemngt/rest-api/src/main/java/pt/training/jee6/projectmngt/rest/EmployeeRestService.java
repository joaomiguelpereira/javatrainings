package pt.training.jee6.projectmngt.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/employees")
public class EmployeeRestService {

	@GET
	public String getEmployees() {
		return "employees";
	}
	
}
