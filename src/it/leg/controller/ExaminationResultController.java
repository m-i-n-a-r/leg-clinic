package it.leg.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.ExaminationResultFacade;
import it.leg.model.ExaminationResult;


@ManagedBean (name = "ExaminationResultController")
@SessionScoped
public class ExaminationResultController {

	@EJB(beanName = "ExaminationResultFacade")
	private ExaminationResultFacade facade;
	private String name;
	private String value;
	private ExaminationResult examinationResult;
	
	public String createExaminationResult() {
		examinationResult = facade.createExaminationResult(name, value);
		
		return "newExaminationType";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public ExaminationResult getExaminationResult() {
		return examinationResult;
	}

	public void setExaminationResult(ExaminationResult examinationResult) {
		this.examinationResult = examinationResult;
	}
}
