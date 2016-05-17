package it.leg.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Esame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Paziente paziente;
	@ManyToOne
	private Medico medico;
	@OneToOne(fetch = FetchType.EAGER)
	private TipologiaEsame tipologia;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrenotazione; 
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSvolgimento;

	public Esame(TipologiaEsame tipologia, Paziente paziente, Medico medico) {
		this.tipologia = tipologia;
		this.paziente = paziente;
		this.medico = medico;
		this.dataSvolgimento = new Date();
		this.dataPrenotazione = new Date();
	}

	// Getters e Setters
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public Date getDataSvolgimento() {
		return dataSvolgimento;
	}
	public void setDataSvolgimento(Date dataSvolgimento) {
		this.dataSvolgimento = dataSvolgimento;
	}
	public TipologiaEsame getTipologia() {
		return tipologia;
	}
	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}
}
