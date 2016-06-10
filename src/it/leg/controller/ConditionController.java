package it.leg.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.ConditionFacade;
import it.leg.model.Condition;

@ManagedBean(name="ConditionController")
@SessionScoped
public class ConditionController {
	@EJB (beanName="ConditionFacade")
	private ConditionFacade facade;

	private String name;
	private String description;

	private Condition condition;
	
	private List<Condition> conditions = facade.findAll();

	public String createCondition(){
		this.condition = facade.createCondition(name, description);

		return "administrationArea";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}



}
