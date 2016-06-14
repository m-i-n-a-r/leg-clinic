package it.leg.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.leg.facade.ExaminationFacade;
import it.leg.facade.ExaminationTypeFacade;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;



@ManagedBean (name = "ExaminationResultController")
@SessionScoped
public class ExaminationResultController {

	@EJB(beanName = "ExaminationFacade")
	private ExaminationFacade examinationFacade;

	@EJB(beanName = "ExaminationTypeFacade")
	private ExaminationTypeFacade examinationTypeFacade;
	
	private List<String> results;
	private List<String> values;
	private List<String> indicators;
	private String value;
	private Long examinationId;
	private Examination examination;
	private ExaminationType examinationType;
	

	public String insertExaminationResult() {
		
		this.values = Arrays.asList(value.split("\\s*,\\s*"));
		
		int length = indicators.size();
		if (length != values.size()) return "error"; // Too many results!
		
		results = new ArrayList<String>(length);
		for (int i = 0; i < length; i++) {
		    results.add(indicators.get(i) + ": " + values.get(i));
		}
		
		this.examination.setResults(results);
		examinationFacade.update(this.examination);
		
		return "administrationArea";
	}
	
	public List<String> getIndicators() {
		this.indicators = examinationType.getIndicators();	
		return indicators;
	}

	public List<String> getResults() {
		return results;
	}

	public void setResults(List<String> results) {
		this.results = results;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public ExaminationType getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}
	
	public void setIndicators(List<String> indicators) {
		this.indicators = indicators;
	}

	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}
	
	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
	// other useful methods
	
	public String retrieveExamination() {
		this.examination = examinationFacade.findByPrimaryKey(examinationId);
		if(this.examination != null) {
			this.indicators = examination.getExaminationType().getIndicators();
			this.examinationType = examination.getExaminationType();
			return "newResults";
		}
		else return "error";
	}

}

