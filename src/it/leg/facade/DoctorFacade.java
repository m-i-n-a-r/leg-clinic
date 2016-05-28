package it.leg.facade;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import it.leg.model.Doctor;

@Stateless(name = "DoctorFacade")
public class DoctorFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;

	public Doctor createDoctor(String name, String surname, String specialization) {
		Doctor doctor=new Doctor(name,surname,specialization);
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
	public List<Doctor> findAll(){
		Query query = em.createQuery("SELECT d FROM  Doctor d");
		return (List<Doctor>) query.getResultList();	

	}
	public Doctor find(String name){
		Doctor doctor= em.find(Doctor.class, name);
		return doctor;
	}

}
