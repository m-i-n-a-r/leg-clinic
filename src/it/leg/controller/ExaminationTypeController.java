package it.leg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationResult;
import it.leg.model.ExaminationType;


@ManagedBean (name = "ExaminationTypeController")
@SessionScoped
public class ExaminationTypeController {

	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade typeFacade;
	
	private String name;
	private String description;
	private Float cost;
	private String resultName;
	
	private ExaminationType examinationType;
	private ExaminationResult examinationResult;
	private List<ExaminationResult> results = new ArrayList<ExaminationResult>();
//	private List<Condition> conditions;
	
	public String createExaminationType() {
		examinationType = typeFacade.createExaminationType(name, description, cost, results);
		return "examinationType";
	}

	public String getResultName() {
		return this.resultName;
	}
	
	public void setResultName(String resultName) {
		this.resultName = resultName;
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

	public List<ExaminationResult> getResults() {
		return results;
	}

	public void setResults(List<ExaminationResult> results) {
		this.results = results;
	}
	
	// useful methods
	
	public String insertExaminationResult() {
		this.examinationType = (ExaminationType) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("examinationType");
		examinationResult = new ExaminationResult(resultName, " ");
		this.results.add(examinationResult);
		
		
		return "newExaminationType";
	}

}
