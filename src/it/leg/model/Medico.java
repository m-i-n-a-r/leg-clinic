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
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String specializzazione;
	@OneToMany (fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id") 
	private List<Esame> esami;
	
	public Medico(String nome, String cognome, String specializzazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
		this.esami = new LinkedList<Esame>();
	}

	// Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	public List<Esame> getEsami() {
		return esami;
	}
	
	// Altri metodi necessari
	
	public void aggiungiEsame(Esame esame) {
		this.esami.add(esame);
	}
}
