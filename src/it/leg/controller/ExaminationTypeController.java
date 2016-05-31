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
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;


@SessionScoped
@ManagedBean
public class ExaminationTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade facade;

	private String name;
	private String description;
	private Float cost;


	public String createExaminationType() {
		facade.createExaminationType(name, description, cost);
		return "examinationType";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Float getCost() {
		return this.cost;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCost(Float cost) {
		this.cost = cost;
	}

}
