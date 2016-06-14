package it.leg.controller;


import java.util.ArrayList;
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
	private Long examinationId;
	private Examination examination;
	private ExaminationType examinationType;
	

	public String insertExaminationResult() {
		int length = indicators.size();
		
		// no indicators at all
		if(length == 0) return "error";
		
		results = new ArrayList<String>(length);
		for (int i = 0; i < length; i++) {
		    results.add(indicators.get(i) + values.get(i));
		}
		
		this.examination.setResults(results);
		examinationFacade.update(this.examination);
		
		// reset some fields
		results = null;
		indicators = null;
		values = null;
		return "administrationArea";
	}
	
	public List<String> getResults() {
		return results;
	}

	public void setResults(List<String> results) {
		this.results = results;
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
	
	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}


	public List<String> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<String> indicators) {
		this.indicators = indicators;
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
		
		// results already compiled
		if(!examination.getResults().isEmpty()) return "error";
		
		if(this.examination != null) {
			this.indicators = examination.getExaminationType().getIndicators();
			this.values = new ArrayList<>();
			for (int i = 0; i < this.indicators.size(); i++) {
			    values.add(": ");
			}
			this.examinationType = examination.getExaminationType();
			return "newResults";
		}
		else return "error";
	}



}

