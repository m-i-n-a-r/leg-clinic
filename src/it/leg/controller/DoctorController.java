package it.leg.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.leg.controller.helper.DoctorHelper;
import it.leg.facade.DoctorFacade;
import it.leg.model.Doctor;



@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(beanName = "DoctorFacade")
	private DoctorFacade facade;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		DoctorHelper helper = new DoctorHelper();
		String nextPage = "/newDoctor.jsp";
		
		if (helper.validate(request)) {
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String specialization = request.getParameter("specialization");

			Doctor doctor = facade.createDoctor(name, surname, specialization);
			request.setAttribute("Doctor", doctor);

			nextPage = "/examinationType.jsp";
	}
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}