package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import main.java.controller.ElevateController;
import main.java.model.RestResponse;
import main.java.service.ElevateServiceClientBase;

@RunWith(MockitoJUnitRunner.class)
public class TestFE {

	RestResponse rrMocked;
	
	@Mock ElevateServiceClientBase escb;
	@Mock HttpServletRequest request;
	@Mock HttpServletResponse response;

	@InjectMocks
	ElevateController elevController;

	@Before
	public void doSetup() {
		rrMocked = new RestResponse();
		rrMocked.setId("A12TEST");
		rrMocked.setDesc("DESCTEST");
	}

	@Test
	public void test() {

		when(escb.callRestService()).thenReturn(rrMocked);

		RestResponse rr = elevController.calltoService();
		assertEquals(rr.getId(), "A12TEST");
		assertEquals(rr.getDesc(), "DESCTEST");
	}

	@Test
	public void testGetMethod() {

		when(escb.callRestService()).thenReturn(rrMocked);

		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new File("newfile.txt"));
			when(request.getContextPath()).thenReturn("path");
			when(response.getWriter()).thenReturn(pw);
			elevController.doGet(request, response);

			pw.flush();

			String content = new String(Files.readAllBytes(Paths.get("newfile.txt")));

			assertEquals(content, "Served1.5 at: path with ID:A12TEST");
			
			//Verify via Mockito that escb.callRestService was called only 1 time
			verify(escb,times(1)).callRestService();

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.close();

	}

}
