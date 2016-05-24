package it.leg.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.leg.controller.helper.ExaminationTypeHelper;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;

public class InsertTypeAction  {


	public String execute (HttpServletRequest request){
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Float cost= Float.parseFloat(request.getParameter("cost"));

		ExaminationTypeFacade facade = new ExaminationTypeFacade();
		ExaminationType examinationType = facade.createExaminationType(name, description, cost);
		request.setAttribute("ExaminationType", examinationType);

		return "/examinationType.jsp";

	}
}
