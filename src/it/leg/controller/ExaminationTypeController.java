package it.leg.controller;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.ExaminationType;


@ManagedBean (name = "ExaminationTypeController")
@SessionScoped
public class ExaminationTypeController {

	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade examinationTypeFacade;
	
	private String name;
	private String description;
	private Float cost;
	private List<String> indicators;
	private String indicatorNames;
	
	private ExaminationType examinationType;
	private List<ExaminationType> examinationTypeList;
//	private List<Condition> conditions;
	
	public String createExaminationType() {
		this.indicators = Arrays.asList(indicatorNames.split("\\s*,\\s*"));
		this.examinationType = new ExaminationType(this.name, this.description, this.cost);
		examinationType.setIndicators(indicators);
		examinationTypeFacade.createExaminationType(this.examinationType);

		// reset some fields
		this.indicatorNames = "";
		return "examinationTypeList";
	}
	public String getIndicatorNames() {
		return this.indicatorNames;
	}
	
	public void setIndicatorNames(String indicatorNames) {
		this.indicatorNames = indicatorNames;
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
	
	public List<ExaminationType> getExaminationTypeList() {
		return this.examinationTypeList;
	}
	
	public String takeExaminationTypeList() {
		this.examinationTypeList = examinationTypeFacade.findAll();
		
		return "examinationsList";
	}
	
	public void setExaminationTypeList(List<ExaminationType> examinationTypeList) {
		this.examinationTypeList = examinationTypeList;
	}
	
	public List<String> getIndicators() {
		return indicators;
	}
	
	public void setIndicators(List<String> indicators) {
		this.indicators = indicators;
	}

}
