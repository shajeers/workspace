package main.java.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import main.java.model.RestResponse;

@Api(value = "Elevate Rest Services")
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
	@ApiOperation(value = "Show Data",
    notes = "Show Data Operation which returns a Hardcoded ID & Desc",
    response = RestResponse.class)
	public RestResponse showData2()
	{
		String result = "reached the Rest Service Desc";
		
		RestResponse rr = new RestResponse();
		rr.setId("A343332");
		rr.setDesc(result);
		return rr;	  
	}
	
	@GET
	@Path("/employee/{employeeId}/departmentId/{deptId}")
	@ApiOperation(value = "Show Data Emp Dept",
    notes = "Show Data Operation which returns a Hardcoded ID & Desc",
    response = Response.class)	
	public Response showDataWithPathParams(@ApiParam(value = "Employeed ID", required = true) @PathParam("employeeId") String employeeId,
			@ApiParam(value = "Department ID", required = true) @PathParam("deptId") String deptId)
	{
		String result = "reached the Rest Service with employee Id : " + employeeId + "and dept id:" + deptId;
		return Response.status(200).entity(result).build();	  
	}
}
