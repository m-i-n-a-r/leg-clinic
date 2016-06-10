package it.leg.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;


@ManagedBean (name = "ExaminationTypeController")
@SessionScoped
public class ExaminationTypeController {

	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade facade;
	private String name;
	private String description;
	private Float cost;
	private ExaminationType examinationType;
	
	public String createExaminationType() {
		examinationType = facade.createExaminationType(name, description, cost);

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

	public ExaminationType getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}

}
