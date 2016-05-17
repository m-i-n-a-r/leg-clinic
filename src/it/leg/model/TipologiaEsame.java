package it.leg.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private Float costo;
//	@Column(nullable = false)
//	private Map<String, String> condizioni;
//	@Column(nullable = false)
//	private Map<String, String> risultati;


	public TipologiaEsame(String nome, String descrizione, Float costo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
//		condizioni = new HashMap<>();
//		risultati = new HashMap<>();
	}

	// Getters e Setters

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCodice() {
		return id;
	}
	public void setCodice(Long codice) {
		this.id = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Float getCosto() {
		return costo;
	}
	public void setCosto(Float costo) {
		this.costo = costo;
	}
//	public Map<String, String> getCondizioni() {
//		return condizioni;
//	}
//	public void setCondizioni(Map<String, String> condizioni) {
//		this.condizioni = condizioni;
//	}
//	public Map<String, String> getRisultati() {
//		return risultati;
//	}
//	public void setRisultati(Map<String, String> risultati) {
//		this.risultati = risultati;
//	}
//
//	// Altri metodi necessari
//
//	public void aggiungiCondizione(String condizione, String periodo) {
//		this.condizioni.put(condizione, periodo);
//	}
}