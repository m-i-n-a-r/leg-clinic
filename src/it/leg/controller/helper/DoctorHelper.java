package it.leg.controller.helper;

import javax.servlet.http.HttpServletRequest;
public class DoctorHelper {

	public boolean validate (HttpServletRequest request){

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String specialization = request.getParameter("specialization");
		boolean correct = true;

		if (name.equals("")) {
			request.setAttribute("nameError","inserisci un nome");
			correct = false;
		}

		if (surname.equals("")) {
			request.setAttribute("descriptionError","inserisci un cognome");
			correct = false;
		}

		if (specialization.equals("")) {
			request.setAttribute("specializationError","inserisci la specializzazione");
			correct = false;
		}

		return correct;

	}
}