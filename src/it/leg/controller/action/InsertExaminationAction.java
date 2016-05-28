package it.leg.controller.action;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import it.leg.facade.ExaminationFacade;
import it.leg.model.Doctor;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;
public class InsertExaminationAction {
	
	@EJB(beanName="ExaminationFacade")
	private ExaminationFacade facade;
	
	public String execute(HttpServletRequest request){
		Examination examination = new Examination();
		
		String patientName = request.getParameter("patient");
		Patient patient = new Patient();
		patient.setName(patientName);
        examination.setPatient(patient);
        
        String examinationTypeName = request.getParameter("type");
        ExaminationType examinationType = new ExaminationType();
        examinationType.setName(examinationTypeName);
        examination.setType(examinationType);
		
        String doctorName = request.getParameter("doctor");
        Doctor doctor = new Doctor();
        doctor.setName(doctorName);
        examination.setDoctor(doctor);
        
		DateValidator dateValidator = new DateValidator();
		examination.setReservationDate(dateValidator.validate(request.getParameter("dataEsame")));
		
		
		facade.createExamination(examinationType, patient, doctor);
		request.setAttribute("examination", examination);
		return "/examination.jsp";
	
	}

}
