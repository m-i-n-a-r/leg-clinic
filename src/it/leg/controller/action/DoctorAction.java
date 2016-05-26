package it.leg.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.leg.facade.DoctorFacade;
import it.leg.model.Doctor;

public class DoctorAction  {


	public String execute (HttpServletRequest request){
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String specialization = request.getParameter("specialization");

		DoctorFacade facade = new DoctorFacade();
		Doctor doctor = facade.createDoctor(name, surname, specialization);
		request.setAttribute("Doctor", doctor);

		return "/examinationType.jsp";

	}
}
