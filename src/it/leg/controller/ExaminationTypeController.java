package it.leg.controller;

import java.util.ArrayList;
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
	private ExaminationTypeFacade facade;
	private ConditionFacade facadeCondition;
    private ExaminationType type;
    private String conditionName;
    private String conditionDescr;
    private Condition condition;
	private String name;
	private String description;
	private Float cost;
	private Long code;
	private List<Condition> preconditions;

	public String createExaminationType() {
            type=facade.createExaminationType(name, description, cost);
			condition=facadeCondition.createCondition(conditionName, conditionDescr);
			type.preconditions = facade.addCondition(this.type,this.condition);
		
		
		
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
	
	private Long getCode() {
		return this.code;
	}
	
	private void setCode(Long code) {
		this.code = code;
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
