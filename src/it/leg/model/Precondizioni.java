package it.leg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Precondizioni {
	@Id
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	
	public Precondizioni(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
