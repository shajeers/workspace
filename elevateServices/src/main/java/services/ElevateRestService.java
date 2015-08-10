package main.java.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/showData")
public class ElevateRestService {
	
	// Sample URL : http://localhost:8080/elevateServices/rest/showData/56fg
	@GET
	@Path("{elevateId}")
	 @Produces("application/json")
	public Response showData(@PathParam("elevateId") String elevateId)
	{
		String result = "reached the Rest Service3 with elevateId : " + elevateId;
		return Response.status(200).entity(result).build();	  
	}

}
