package it.leg.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.ConditionFacade;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.Condition;
import it.leg.model.ExaminationType;


@ManagedBean (name = "ExaminationTypeController")
@SessionScoped
public class ExaminationTypeController {


	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade examinationTypeFacade;
	@EJB
	private ConditionFacade conditionFacade;

	private String name;
	private String description;
	private Float cost;
	private List<String> indicators;
	private String indicatorNames;
	private String conditionName;
	private String conditionDescr;
	private ExaminationType examinationType;
	private List<ExaminationType> examinationTypeList;
	private List<Condition> conditions;
	private Condition condition;

	public String createExaminationType() {
		this.indicators = Arrays.asList(indicatorNames.split("\\s*,\\s*"));
		this.examinationType = new ExaminationType(this.name, this.description, this.cost);
		examinationType.setIndicators(indicators);

		this.condition= conditionFacade.createCondition(conditionName, conditionDescr);
		this.conditions= examinationTypeFacade.addCondition(examinationType, condition);

		examinationTypeFacade.createExaminationType(this.examinationType);

		// resets some fields
		this.indicatorNames = "";
		return "administrationArea";
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
	public String getconditionDescr() {
		return conditionDescr;
	}

	public void setconditionDescr(String conditionDescr) {
		this.conditionDescr = conditionDescr;
	}

	public String getconditionName() {
		return conditionName;
	}

	public void setconditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	
	public String getConditionName() {
		return conditionName;
	}
	
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	
	public String getConditionDescr() {
		return conditionDescr;
	}
	
	public void setConditionDescr(String conditionDescr) {
		this.conditionDescr = conditionDescr;
	}
	
	public List<Condition> getConditions() {
		return conditions;
	}
	
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	public Condition getCondition() {
		return condition;
	}
	
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
}
