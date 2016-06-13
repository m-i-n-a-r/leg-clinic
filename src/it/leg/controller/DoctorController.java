package it.leg.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.DoctorFacade;
import it.leg.model.Doctor;


@ManagedBean (name = "DoctorController")
@SessionScoped
public class DoctorController {
       
	@EJB(beanName = "DoctorFacade")
	private DoctorFacade facade;
	
	private Long id;
	
	private String name;
	private String surname;
	private String specialization;
	
	private Doctor doctor;
	private List<Doctor> doctors;
	
	public String createDoctor() {
		this.doctor = facade.createDoctor(name, surname, specialization);

		return "administrationArea";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getSpecialization() {
		return this.specialization;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public List<Doctor> getDoctors() {
		return this.doctors;
	}
	
	public String takeDoctorList() {
		this.doctors = this.facade.findAll();
		
		return "DoctorExaminationsList";
	}
}