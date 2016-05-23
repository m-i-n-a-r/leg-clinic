package it.leg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.leg.controller.action.ActionInsertType;
import it.leg.controller.helper.HelperTypeExamination;



@WebServlet("/ExaminationTypeController")
public class ExaminationTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HelperTypeExamination helper = new HelperTypeExamination();
		ActionInsertType action = new ActionInsertType();
		String nextPage = "/newExaminationType.jsp";
		if (helper.isValid(request)) {
			nextPage = action.manage(request);
	}
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
