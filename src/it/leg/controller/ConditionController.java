package it.leg.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import it.leg.facade.ConditionFacade;
import it.leg.model.Condition;
import it.leg.model.ExaminationType;

@ManagedBean(name="ConditionController")
@SessionScoped
public class ConditionController {
	@EJB (beanName="ConditionFacade")
	private ConditionFacade facade;
    
	
	private String name;
	private String description;
	
	
	
	public String createCondition(){
		Condition condition= facade.createCondition(name, description);
	
		return "examinationType";
		}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
