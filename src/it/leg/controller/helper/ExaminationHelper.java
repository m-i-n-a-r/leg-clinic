package it.leg.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class ExaminationHelper {

	
	public boolean validate (HttpServletRequest request){

		String type = request.getParameter("type");
		String patient = request.getParameter("patient");
		String doctor = request.getParameter("doctor");
		boolean correct = true;

		if (type.equals("")) {
			request.setAttribute("typeError","inserisci una tipologia di esame");
			correct = false;
		}

		if (patient.equals("")) {
			request.setAttribute("patientError","inserisci paziente");
			correct = false;
		}

		if (doctor.equals("")) {
			request.setAttribute("doctorError","inserisci un medico");
			correct = false;
		}
		// verificare che la tipologia e il paziente esistano in LegClinic?!
		
		return correct;
		
	}
	
}
