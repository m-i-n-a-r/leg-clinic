package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.Patient;

@Stateless(name = "PatientFacade")
public class PatientFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;
	
	public Patient createPatient(String name, String surname, String email, String password) {	
		Patient patient = new Patient(name, surname, email, password);
		em.persist(patient);
		return patient;
	}
	
	public void delete(Patient patient) {
		em.remove(patient);
	}
	
	public void update(Patient patient) {
		em.merge(patient);
	}
	
	public Patient findByPrimaryKey(Long id) {
		Patient patient = em.find(Patient.class, id);
		return patient;
	}
	
	public List<Patient> findAll() {
		Query query = em.createQuery("SELECT p FROM Patient p");
	    return (List<Patient>) query.getResultList();	
	}
	
	public Patient findByName(String name){
		Query queryCF = em.createQuery("SELECT OBJECT(p) FROM Patient AS p WHERE p.name=?1");
		queryCF.setParameter(1, name);
		
		List<Patient> patients = queryCF.getResultList();
		if (patients.isEmpty()) {
			return null;
		} 
		else {
			Patient patient = (Patient)patients.get(0);
			return patient;
		}
	}
	
	public Long getIdByname(String name) {
	    Query query = em.createQuery("SELECT OBJECT(p) FROM Patient AS p WHERE p.name=?1");
	    query.setParameter(1, name);
	    
	    List<Patient> patients = query.getResultList();
	    if (patients.isEmpty()) {
	      return null;
	    } 
	    else {
	      Patient p = (Patient)patients.get(0);
	      return p.getId();
	    }
	  }
	public Patient findByEmail(String email) {
		Query queryCF = em.createQuery("SELECT OBJECT(p) FROM Patient AS p WHERE p.email=?1");
		queryCF.setParameter(1, email);
		
		List<Patient> patients = queryCF.getResultList();
		if (patients.isEmpty()) {
			return null;
		} 
		else {
			Patient patient = (Patient)patients.get(0);
			return patient;
		}
	}
	
}
