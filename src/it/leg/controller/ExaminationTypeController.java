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

import it.leg.controller.helper.ExaminationTypeHelper;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;



@WebServlet("/ExaminationTypeController")
public class ExaminationTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade facade;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		ExaminationTypeHelper helper = new ExaminationTypeHelper();
		String nextPage = "/newExaminationType.jsp";

		if (helper.validate(request)) {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Float cost= Float.parseFloat(request.getParameter("cost"));

			ExaminationType examinationType = facade.createExaminationType(name, description, cost);
			request.setAttribute("ExaminationType", examinationType);

			nextPage = "/examinationType.jsp";
		}

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
