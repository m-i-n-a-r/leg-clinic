package it.leg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;

@WebServlet("/ExaminationTypeList")
public class ExaminationTypeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ExaminationType> examinationTypesList;
	private ExaminationTypeFacade examinationController;
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.examinationController = new ExaminationTypeFacade();
		this.examinationTypesList = this.examinationController.findAll();
		
		HttpSession session = request.getSession();
		session.setAttribute("examinationTypeList", examinationTypesList);
		
		String nextPage = "/ExaminationType.jsp";
		nextPage = response.encodeURL(nextPage);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
