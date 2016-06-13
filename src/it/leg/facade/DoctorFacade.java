package it.leg.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.Doctor;
import it.leg.model.Patient;

@Stateless(name = "DoctorFacade")
public class DoctorFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;

	public Doctor createDoctor(String name, String surname, String specialization) {
		Doctor doctor = new Doctor(name, surname, specialization);
		em.persist(doctor);
		return doctor;
	}

	public void delete(Doctor doctor){
		em.remove(doctor);
	}
	
	public void update(Doctor doctor){
		em.merge(doctor);
	}
	
	public Doctor findByPrimaryKey(Long id){
		Doctor doctor = em.find(Doctor.class, id);
		return doctor;
	}
	
	public Doctor findBySurname(String surname){
		Query queryCF = em.createQuery("SELECT OBJECT(d) FROM Doctor AS d WHERE d.surname=?1");
		queryCF.setParameter(1, surname);
		
		List<Doctor> doctors = queryCF.getResultList();
		if (doctors.isEmpty()) {
			return null;
		} 
		else {
			Doctor doctor = (Doctor)doctors.get(0);
			return doctor;
		}
	}
	
	public List<Doctor> findAll() {
		Query query = em.createQuery("SELECT d FROM  Doctor d");
		return (List<Doctor>) query.getResultList();	
	}
	
	public Long getIdBySurname(String surname) {
		Query query = em.createQuery("SELECT OBJECT(d) FROM Doctor AS d WHERE d.surname=?1");
		query.setParameter(1, surname);
		
		List<Doctor> doctors = query.getResultList();
		if (doctors.isEmpty()) {
			return null;
		} 
		else {
			Doctor d = (Doctor)doctors.get(0);
			return d.getId();
		}
	}

}
