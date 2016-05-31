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

import it.leg.controller.helper.ExaminationTypeHelper;
import it.leg.facade.DoctorFacade;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.facade.PatientFacade;
import it.leg.model.ExaminationType;

public class PatientController {
	
	@SessionScoped
	@ManagedBean
	public class DoctorController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		@EJB(beanName = "PatientFacade")
		private PatientFacade facade;
		
		private String email;
		private String name;
		private String surname;
		private String password;
		
		public String createPatient() {
			facade.createPatient(name, surname, email, password);

			return "examinationType";
		}
		
		public String getEmail() {
			return this.email;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getSurname() {
			return this.surname;
		}
		
		public String getPassword() {
			return this.password;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setSurname(String surname) {
			this.surname = surname;
		}
		
		public void setPassword(String password) {
			this.surname = password;
		}

	}
}
