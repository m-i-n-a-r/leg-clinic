package it.leg.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import it.leg.facade.AdminFacade;
import it.leg.facade.PatientFacade;
import it.leg.model.Admin;
import it.leg.model.Patient;


@ManagedBean (name = "LoginController")
@SessionScoped
public class LoginController {
       
	@EJB(beanName = "PatientFacade")
	private PatientFacade patientFacade;
	
	@EJB(beanName = "AdminFacade")	
	private AdminFacade adminFacade;
	
	private String email;
	private String password;

	
	private Admin admin;
	private Patient patient;
	
	private LoginHelper helper;
	
	public String autenticateUser() {
		this.helper = new LoginHelper();
		
		if (this.exists(email)) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			
			if (this.isAdmin(email)) {
				this.setAdmin(this.adminFacade.findByEmail(email));
					
				if (helper.validatePassword(password, this.admin.getPassword())) {
					session.setAttribute("user", "admin");
					return "admin/administrationArea";
				}
				else {
					return "error";
				}
			}
			else {
				this.setPatient(this.patientFacade.findByEmail(email));
					
				if (helper.validatePassword(password, this.patient.getPassword())) {
					session.setAttribute("user", "patient");
					return "user/personalArea";
				}
				else {
					return "error";
				}
			}
		}
		
		return "error";
	}
	
	private boolean exists(String email) {
		boolean correct;
		
		if (this.isAdmin(email))
			correct = !(this.adminFacade.findByEmail(email) == null);
		else
			correct = !(this.patientFacade.findByEmail(email) == null);
		
		return correct;
	}
	
	private boolean isAdmin(String email) {
		return !(adminFacade.findByEmail(email) == null);
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Admin getAdmin() {
		return this.admin;
	}
	
	public Patient getPatient() {
		return this.patient;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}