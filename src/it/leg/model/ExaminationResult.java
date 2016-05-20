package it.leg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExaminationResult {	
	
	@Id
	private String name;
	
	@Column (nullable = false)
	private String value;

	public ExaminationResult(String name, String value) {
		this.name = name;
		this.value = value;
	}

	// Getters and Setters
	
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
	
}
