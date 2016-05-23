package it.leg.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.leg.controller.helper.HelperTypeExamination;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;

public class ActionInsertType  {

	
	//ActionMethod
	public String manage (HttpServletRequest request){
		
		//data validation 
		HelperTypeExamination helper = new HelperTypeExamination();
		if (helper.isValid(request)){
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Float cost= Float.parseFloat(request.getParameter("cost"));
			
			//if data validation=ok => facade method in order to create E.type
			ExaminationTypeFacade facade= new ExaminationTypeFacade();
			ExaminationType type= facade.createExaminationType(name, description, cost);
			request.setAttribute("ExaminationType",type);
			
			return "/ExaminationType.jsp";
		}
		
		//if data validation=notOk => return to initialForm to insert newExaminationType
		else {
			return "/NewExaminationType.jsp";
		}
			
	}
}
