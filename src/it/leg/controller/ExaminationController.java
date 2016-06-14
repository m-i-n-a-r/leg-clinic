package it.leg.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.DoctorFacade;
import it.leg.facade.ExaminationFacade;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.facade.PatientFacade;
import it.leg.model.Doctor;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;


@ManagedBean (name = "ExaminationController")
@SessionScoped
public class ExaminationController {

	@EJB(beanName = "ExaminationFacade")
	private ExaminationFacade examinationFacade;
	
	@EJB(beanName = "DoctorFacade")
	private DoctorFacade doctorFacade;
	
	@EJB(beanName = "PatientFacade")
	private PatientFacade patientFacade;
	
	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade examinationTypeFacade;
	
	private String doctorSurname;
	private String examinationTypeName;
	private String patientEmail;
	private String patientName;
	
	private Examination examination;
	private Doctor doctor;
	private Patient patient;
	private ExaminationType examinationType;
	private List<Examination> allExamination;
	private List<Examination> patientExamination;
	
	public String createExamination() {
		
		doctor = doctorFacade.findBySurname(doctorSurname);
		if(doctor == null) return "error";
		patient = patientFacade.findByEmail(patientEmail);
		if(patient == null) return "error";
		examinationType = examinationTypeFacade.findByName(examinationTypeName);
		if(examinationType == null) return "error";
		examination = new Examination(examinationType, patient, doctor);
		examinationFacade.createExamination(examination);
		
		// reset some fields
		this.doctorSurname = null;
		this.patientEmail = null;
		this.examinationTypeName = null;
		return "administrationArea";
	}

	public ExaminationType getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDoctorSurname() {
		return doctorSurname;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}

	public String getExaminationTypeName() {
		return examinationTypeName;
	}

	public void setExaminationTypeName(String examinationTypeName) {
		this.examinationTypeName = examinationTypeName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public List<Examination> getPatientExamination() {
		return patientExamination;
	}
	
	public void setPatientExamination(List<Examination> patientExamination) {
		this.patientExamination = patientExamination;
	}
	

	public List<Examination> getAllExamination() {
		return allExamination;
	}

	public void setAllExamination(List<Examination> allExamination) {
		this.allExamination = allExamination;
	}
	

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	// other useful methods
	
	public String examinationChoosing() {
		this.allExamination = this.examinationFacade.findAll();
		return "newFilling";
	}
	
	public String showpatientExamination() {
		Long id = patientFacade.getIdByname(patientName);	
		if (id != null) {
			this.patientExamination = this.examinationFacade.findAllbyId(id);
			return "examinationPatientList";
		}
		
		return "error";
	}


	
}