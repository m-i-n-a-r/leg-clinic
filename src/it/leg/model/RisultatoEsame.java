package it.leg.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RisultatoEsame {
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private String valore;
	
	public RisultatoEsame(String nome, String valore) {
		this.nome = nome;
		this.valore = valore;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getValore() {
		return this.valore;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValore(String valore) {
		this.valore = valore;
	}
	
}
