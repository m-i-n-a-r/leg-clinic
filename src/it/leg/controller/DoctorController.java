package it.leg.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.leg.controller.helper.DoctorHelper;
import it.leg.facade.DoctorFacade;
import it.leg.model.Doctor;


@SessionScoped
@ManagedBean
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(beanName = "DoctorFacade")
	private DoctorFacade facade;
	
	private String name;
	private String surname;
	private String specialization;
	
	public String createDoctor() {
		facade.createDoctor(name, surname, specialization);

		return "examinationType";
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

}