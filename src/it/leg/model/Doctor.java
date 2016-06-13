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
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private String specialization;
	
	@OneToMany (fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id") 
	private List<Examination> examinations;
	
	public Doctor(String name, String surname, String specialization) {
		this.name = name;
		this.surname = surname;
		this.specialization = specialization;
		this.examinations = new LinkedList<Examination>();
	}

	// Getters e Setters
	
	public Doctor() {
	
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public List<Examination> getExaminations() {
		return examinations;
	}
	
	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}
	
	// Useful methods
	
	public void addExamination(Examination examination) {
		this.examinations.add(examination);
	}
	
	public Long getId() {
		return this.id;
	}

}
