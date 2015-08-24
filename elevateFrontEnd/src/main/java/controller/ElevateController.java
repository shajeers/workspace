package main.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.inject.Inject;

import main.java.model.RestResponse;
import main.java.service.ElevateServiceClient;
import main.java.service.ElevateServiceClientBase;

/**
 * Servlet implementation class ElevateController
 */
@WebServlet("/ElevateController")
public class ElevateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ElevateServiceClientBase escb;

    /**
     * Default constructor. 
     */
    public ElevateController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//RestResponse rr = esc.callRestService();
		//esc.callRestServiceWithParam();
		//escb.callRestServiceWithPathParam();
		RestResponse rr = calltoService();

		response.getWriter().append("Served1.5 at: ").append(request.getContextPath()).append(" with ID:" + rr.getId());
	}
	
	public RestResponse calltoService()
	{
		RestResponse rr = escb.callRestService();
		return rr;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
