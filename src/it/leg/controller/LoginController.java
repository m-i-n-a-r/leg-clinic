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

import it.leg.facade.AdminFacade;
import it.leg.facade.PatientFacade;
import it.leg.model.Admin;
import it.leg.model.Patient;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "PatientFacade")
	private PatientFacade patientFacade;
	
	@EJB(beanName = "AdminFacade")
	private AdminFacade adminFacade;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String nextPage = "/login.jsp";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email.equals(""))
			request.setAttribute("emailError", "Inserisci l'email");
		
		if (password.equals(""))
			request.setAttribute("passwordError", "Inserisci la password");
		
		if (this.isAdmin(email)) {
			Admin adminCurrent = this.adminFacade.findByEmail(email);
			
			if (adminCurrent.getPassword().equals(password))
				nextPage = "/administrationArea.jsp";
			else
				request.setAttribute("loginError", "Email e/o password errati");
		}
		else {
			Patient currentPatient = this.patientFacade.findByEmail(email);
			
			if (currentPatient.getPassword().equals(password))
				nextPage = "/personalArea.jsp";
			else
				request.setAttribute("loginError", "Email e/o password errati");
		}
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	private boolean isAdmin(String email) {
		return !(adminFacade.findByEmail(email) == null);
	}
}