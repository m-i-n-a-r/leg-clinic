package it.leg.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Examination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.EAGER)
	private ExaminationType type;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date examinationDate;

	public Examination(ExaminationType type, Patient patient, Doctor doctor) {
		this.type = type;
		this.patient = patient;
		this.doctor = doctor;
		
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
		String data = df1.format(new Date());
		
		try {
			this.reservationDate = df1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.examinationDate = df1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters e Setters
	
	public Examination() {
		
	}

	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Date getReservationDate() {
		return reservationDate;
	}
	
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public Date getExaminationDate() {
		return examinationDate;
	}
	
	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}
	
	public ExaminationType getType() {
		return type;
	}
	
	public void setType(ExaminationType type) {
		this.type = type;
	}
	
}
