package it.leg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.leg.controller.action.InsertDoctorAction;
import it.leg.controller.helper.DoctorHelper;



@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		DoctorHelper helper = new DoctorHelper();
		InsertDoctorAction action = new InsertDoctorAction();
		String nextPage = "/newDoctor.jsp";
		
		if (helper.validate(request)) {
			nextPage = action.execute(request);
	}
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}