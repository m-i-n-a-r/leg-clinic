package it.leg.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.DoctorFacade;
import it.leg.facade.ExaminationFacade;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.Doctor;
import it.leg.model.Examination;


@ManagedBean (name = "DoctorExamsListController")
@SessionScoped
public class DoctorExamsListController {
	
	@EJB(beanName = "ExaminationFacade")
	private ExaminationFacade examinationFacade;
	
	@EJB(beanName = "DoctorFacade")
	private DoctorFacade doctorFacade;
	
	private String surname;

	private Doctor doctor;
	private List<Examination> examinations;
	
	public String showExams() {
		if (this.exists(this.surname)) {
			this.doctor = doctorFacade.findBySurname(this.surname);
			this.setExaminations(this.doctor.getExaminations());
			
			return "doctorExamsList";
		}
		
		return "error";
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public List<Examination> getExaminations() {
		return this.examinations;
	}
	
	public void setExaminations(List<Examination> exams) {
		this.examinations = exams;
	}
	
	public Doctor getDoctor() {
		return this.doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public boolean exists(String surname) {
		return !(this.doctorFacade.findBySurname(surname) == null);
	}
}
