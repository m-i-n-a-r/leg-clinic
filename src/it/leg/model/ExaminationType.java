package it.leg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Float cost;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="Indicator", joinColumns=@JoinColumn(name="examinationType_id"))
	@Column(name="name", nullable = false)
	private List<String> indicators;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="examinationType_id")
	public List<Condition> preconditions;
	

	public ExaminationType(String name, String description, Float cost) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.indicators = new ArrayList<>();
		this.preconditions = new ArrayList<>();
	}

	public ExaminationType() {
		this.preconditions = new ArrayList <Condition>();
		this.indicators = new ArrayList<>();
	}

	// Getters e Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public List<String> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<String> indicators) {
		this.indicators = indicators;
	}
	
	// Useful methods
	
	public void addCondition(Condition condition) {
		this.preconditions.add(condition);
	}
	
	public void addIndicator(String indicator) {
		this.indicators.add(indicator);
	}
	
	public String toString() {
		return "Nome: " + this.name + "Descrizione: " + this.description;
	}
	
	public List<Condition> getPreconditions() {
		return preconditions;
	}
	
	public void setPreconditions(List<Condition> preconditions) {
		this.preconditions = preconditions;
	}

	
	
}