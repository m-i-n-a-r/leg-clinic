package it.leg.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ExaminationType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Float cost;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="condition_id")
	private List<Condition> preconditions;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private List<ExaminationResult> examResults;


	public ExaminationType(String name, String description, Float cost) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		preconditions = new LinkedList<>();
		examResults = new LinkedList<>();
	}

	// Getters e Setters

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getCost() {
		return cost;
	}
	
	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	// Useful methods
	
	public void AddCondition(Condition condition) {
		this.preconditions.add(condition);
	}
	
	public void AddExaminationResult(ExaminationResult result) {
		this.examResults.add(result);
	}
	
	public String toString() {
		return "Nome: " + this.name + "Descrizione: " + this.description;
	}
}