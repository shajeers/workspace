package main.java.service;

import main.java.model.RestResponse;

public interface ElevateServiceClientBase {
	
	public RestResponse callRestService();
	public void callRestServiceWithParam();
	public void callRestServiceWithPathParam();

}
