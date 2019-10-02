package br.com.ciclistas.sjc.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ciclistas.sjc.model.Status;
import br.com.ciclistas.sjc.resources.utils.JaxrsUtils;



/**
 * @author Pedro Hos
 *
 */

@Path("status")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {
	
	@GET
	public Response getAllStatus() {
		return Response.ok(JaxrsUtils.throw404IfNull(Status.listAll())).build();
	}
	
}
