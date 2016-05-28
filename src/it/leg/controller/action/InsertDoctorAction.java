package it.leg.controller.action;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import it.leg.facade.DoctorFacade;
import it.leg.model.Doctor;

public class InsertDoctorAction  {

	@EJB(beanName="DoctorFacade")
	private DoctorFacade facade;

	public String execute (HttpServletRequest request){
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String specialization = request.getParameter("specialization");

		Doctor doctor = facade.createDoctor(name, surname, specialization);
		request.setAttribute("Doctor", doctor);

		return "/examinationType.jsp";

	}
}
