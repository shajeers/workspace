package main.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.service.ElevateServiceClient;

/**
 * Servlet implementation class ElevateController
 */
@WebServlet("/ElevateControllerProtected")
@ServletSecurity(
@HttpConstraint(transportGuarantee = TransportGuarantee.NONE,
    rolesAllowed = {"role1"}))
public class ElevateControllerProtected extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ElevateControllerProtected() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		ElevateServiceClient esc = new ElevateServiceClient();
		//RestResponse rr = esc.callRestService();
		//esc.callRestServiceWithParam();
		esc.callRestServiceWithPathParam();
		response.getWriter().append("Protected Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
