package it.leg.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.leg.model.Admin;
import it.leg.model.Patient;

public class LoginAction {
	
	public String executePatient(HttpServletRequest request) {
//		Facade facade = new Facade();
		Patient currentPatient = new Patient();
		currentPatient.setPassword(request.getParameter("password"));
		currentPatient.setEmail(request.getParameter("email"));
//		PatientFacade.insert(currentPatient);
		request.setAttribute("currentPatient", currentPatient);
		return "/personalArea.jsp";
	}
	
	public String executeAdmin(HttpServletRequest request) {
		Admin administrator = new Admin();
		administrator.setEmail(request.getParameter("email"));
		request.setAttribute("administrator", administrator);
		return "/administrationArea.jsp";
	}
}
