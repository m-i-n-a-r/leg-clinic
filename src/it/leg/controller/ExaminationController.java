package it.leg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.leg.controller.action.InsertExaminationAction;
import it.leg.controller.helper.ExaminationHelper;
import it.leg.facade.ExaminationFacade;


@WebServlet("/ExaminationController")
public class ExaminationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	             ExaminationHelper helper = new ExaminationHelper();	
	             InsertExaminationAction action = new InsertExaminationAction();
	             String nextPage= "/newExamination.jsp";
	             
	             if (helper.validate(request)){
	            	 nextPage=action.execute(request);
	             }
	             
	ServletContext servletContext = getServletContext();
	RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
	rd.forward(request, response);
	}
}
