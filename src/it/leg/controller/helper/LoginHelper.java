package it.leg.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHelper {

	public boolean validate(HttpServletRequest request, HttpServletResponse response) {
		// request management

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// controls 

		boolean correct = true;

		if(email.equals("")) {
			correct = false;
			request.setAttribute("emailError", "Inserisci l'email");
		}

		if(password.equals("")) {
			correct = false;
			request.setAttribute("passwordError", "Inserisci la password");
		}

		return correct;
	}
	
	public boolean isAdmin(HttpServletRequest request, HttpServletResponse response) {
		// request management

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// controls
		
		if(password.equals("admin") && email.equals("admin@admin.admin")) return true;
		else return false;
	}
}
