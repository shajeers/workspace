package main.java.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.model.RestResponse;


@Path("/showData")
public class ElevateRestService {
	
	// Sample URL : http://localhost:8080/elevateServices/rest/showData/56fg
	@GET
	@Path("inside")
	 @Produces("application/json")
	public Response showData(@QueryParam("elevateId") String elevateId)
	{
		String result = "reached the Rest Service3 with elevateId : " + elevateId;
		return Response.status(200).entity(result).build();	  
	}
	
	// Sample URL : http://localhost:8080/elevateServices/rest/showData
	@GET
	 @Produces(MediaType.APPLICATION_JSON)
	public RestResponse showData2()
	{
		String result = "reached the Rest Service";
		
		RestResponse rr = new RestResponse();
		rr.setId("2");
		rr.setDesc(result);
		return rr;	  
	}
	
	@GET
	@Path("/employee/{employeeId}/departmentId/{deptId}")
	public Response showDataWithPathParams(@PathParam("employeeId") String employeeId,@PathParam("deptId") String deptId)
	{
		String result = "reached the Rest Service with employee Id : " + employeeId + "and dept id:" + deptId;
		return Response.status(200).entity(result).build();	  
	}
}
