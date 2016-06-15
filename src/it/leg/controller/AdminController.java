package it.leg.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.AdminFacade;
import it.leg.model.Admin;


@ManagedBean (name = "AdminController")
@SessionScoped
public class AdminController {
       
	@EJB(beanName = "AdminFacade")
	private AdminFacade facade;
	
	private Long id;
	
	private String email;
	private String name;
	private String surname;
	private String password;
	
	private Admin admin;
	private LoginHelper helper = new LoginHelper();;
	
	public String createAdmin() {
		this.admin = facade.createAdmin(name, surname, email, this.helper.md5(password));

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

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}