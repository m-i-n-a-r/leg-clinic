package it.leg.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Patient;

public class PatientFacade {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public Patient createPatient(String name, String surname, String email, String password) {	
		tx.begin();
		Patient patient= new Patient(name,surname,email,password);
		em.persist(patient);
		tx.commit();
		return patient;
	}
	
	public void delete(Patient patient) {
		tx.begin();
		
		em.remove(patient);
		
		tx.commit();
	}
	
	public void update(Patient patient) {
		tx.begin();
		
		em.merge(patient);
		
		tx.commit();
	}
	
	public Patient findByPrimaryKey(Long id) {
		tx.begin();
		
		Patient patient = em.find(Patient.class, id);
		
		tx.commit();
		
		return patient ;
	}
	
	public List<Patient> findAll() {
		
		Query query = em.createQuery("SELECT p FROM Patient p");
	    return (List<Patient>) query.getResultList();	
	}
	
}
