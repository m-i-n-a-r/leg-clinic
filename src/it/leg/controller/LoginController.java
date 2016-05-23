package it.leg.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.leg.model.Patient;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// request management

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// controls 
		
		boolean incorrect = false;
		String nextPage = null;

		if(email.equals("")) {
			incorrect = true;
			request.setAttribute("emailError", "Inserisci l'email");
		}

		if(password.equals("")) {
			incorrect = true;
			request.setAttribute("passwordError", "Inserisci la password");
		}

		if(incorrect) nextPage = "/login.jsp";
		else {

			// everything is ok
			
			Patient currentPatient = new Patient();
			currentPatient.setEmail(email);
			currentPatient.setPassword(password);

			request.setAttribute("patient", currentPatient);
			nextPage = "/personalArea.jsp";
		}
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}

