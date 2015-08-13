package main.java.service;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import main.java.model.RestResponse;

public class ElevateServiceClient {
	
	public RestResponse callRestService()
	{
		RestResponse rr = null;
		try {
			
			  ClientConfig clientConfig = new DefaultClientConfig();
			  clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			  Client client = Client.create(clientConfig);			
			 
			//Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8180/elevateServices/rest/showData");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
 
			rr = response.getEntity(RestResponse.class);
			System.out.println("ID:"+ rr.getId());
			System.out.println("Desc:"+rr.getDesc());
			

 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return rr;
	}
	
	public void callRestServiceWithParam()
	{
		RestResponse rr = null;
		try {
			
			  ClientConfig clientConfig = new DefaultClientConfig();
			  clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			  Client client = Client.create(clientConfig);			
			 
			//Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8180/elevateServices/rest/showData");
			ClientResponse response = webResource.path("inside").queryParam("elevateId", "shj").accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String resp = response.getEntity(String.class);
			
			System.out.println("response:"+ resp);

 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		

	}	
	
	public void callRestServiceWithPathParam()
	{
		RestResponse rr = null;
		try {
			
			  ClientConfig clientConfig = new DefaultClientConfig();
			  clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			  Client client = Client.create(clientConfig);			
			 
			//Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8180/elevateServices/rest/showData/employee/U12345/departmentId/eCom");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String resp = response.getEntity(String.class);
			
			System.out.println("response:"+ resp);

 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		

	}		

}
