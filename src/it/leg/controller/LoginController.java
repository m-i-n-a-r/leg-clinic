package it.leg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import it.leg.controller.action.LoginAction;
import it.leg.controller.helper.LoginHelper;
import it.leg.model.Patient;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		LoginHelper helper = new LoginHelper();
		LoginAction action = new LoginAction();
		String nextPage = "/login.jsp";

		if (helper.validate(request, response) && helper.isAdmin(request, response)) 
			nextPage = action.executeAdmin(request);
		else if (helper.validate(request, response))
			nextPage = action.executePatient(request);

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}