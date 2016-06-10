package it.leg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Condition {
	
	@Id
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	
	public Condition(String name, String description) {
		this.name = name;
		this.description = description;	
	}
	
	public Condition() {}
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "nome:" + this.name + " descrizione:" + this.description;
	}
}
