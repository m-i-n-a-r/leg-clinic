package it.leg.controller.action;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;

public class InsertTypeAction  {
	@EJB(beanName="ExaminationTypeFacade")
	private ExaminationTypeFacade facade;

	public String execute (HttpServletRequest request){
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Float cost= Float.parseFloat(request.getParameter("cost"));

		ExaminationType examinationType = facade.createExaminationType(name, description, cost);
		request.setAttribute("ExaminationType", examinationType);

		return "/examinationType.jsp";

	}
}
