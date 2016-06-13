package it.leg.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.PatientFacade;
import it.leg.model.Patient;


@ManagedBean (name = "PatientController")
@SessionScoped
public class PatientController {
       
	@EJB(beanName = "PatientFacade")
	private PatientFacade facade;
	
	private Long id;
	
	private String email;
	private String name;
	private String surname;
	private String password;
	
	private Patient patient;
	
	public String createPatient() {
		this.patient = facade.createPatient(name, surname, email, password);

		return "administrationArea";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}