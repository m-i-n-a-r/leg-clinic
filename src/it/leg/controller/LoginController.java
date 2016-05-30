package it.leg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import it.leg.controller.helper.LoginHelper;
import it.leg.facade.PatientFacade;
import it.leg.model.Admin;
import it.leg.model.Patient;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "PatientFacade") // 2 Facades needed? We have to find a solution D:
	private PatientFacade facade;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		LoginHelper helper = new LoginHelper();
		String nextPage = "/login.jsp";

		if (helper.validate(request, response) && helper.isAdmin(request, response)) {
			Admin administrator = new Admin();
			administrator.setEmail(request.getParameter("email"));
			request.setAttribute("administrator", administrator);
			nextPage = "/administrationArea.jsp";	
		}
		
		else if (helper.validate(request, response)) {
			Patient currentPatient = new Patient();
			currentPatient.setPassword(request.getParameter("password"));
			currentPatient.setEmail(request.getParameter("email"));
			request.setAttribute("currentPatient", currentPatient);
			nextPage = "/personalArea.jsp";
		}

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}