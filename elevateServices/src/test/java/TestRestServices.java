package test.java;

import org.junit.Ignore;
import org.junit.Test;

import main.java.model.RestResponse;
import main.java.services.ElevateRestService;

import static org.junit.Assert.assertEquals;

public class TestRestServices {
	
	@Test
	public void testElevateService()
	{
		ElevateRestService ers = new ElevateRestService();
		
		RestResponse restResp = ers.showData2();
		
		assertEquals("2",restResp.getId());
		
	}

}
