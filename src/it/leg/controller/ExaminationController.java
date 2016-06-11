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

import org.apache.commons.validator.routines.DateValidator;

import it.leg.facade.ExaminationFacade;
import it.leg.model.Doctor;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;

@WebServlet("/ExaminationController")
public class ExaminationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "ExaminationFacade")
	private ExaminationFacade facade;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ExaminationHelper helper = new ExaminationHelper();	
		String nextPage= "/newExamination.jsp";
//
//		if (helper.validate(request)){
//			Examination examination = new Examination();
//
//			String patientName = request.getParameter("patient");
//			Patient patient = new Patient();
//			patient.setName(patientName);
//			examination.setPatient(patient);
//
//			String examinationTypeName = request.getParameter("type");
//			ExaminationType examinationType = new ExaminationType();
//			examinationType.setName(examinationTypeName);
//			examination.setType(examinationType);
//
//			String doctorName = request.getParameter("doctor");
//			Doctor doctor = new Doctor();
//			doctor.setName(doctorName);
//			examination.setDoctor(doctor);
//
//			DateValidator dateValidator = new DateValidator();
//			examination.setReservationDate(dateValidator.validate(request.getParameter("dataEsame")));
//
//
//			facade.createExamination(examinationType, patient, doctor);
//			request.setAttribute("examination", examination);
//			nextPage = "/examination.jsp";
//		}

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
