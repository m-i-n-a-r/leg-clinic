package it.leg.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Doctor;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;

public class ExaminationFacade {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public Examination createExamination(ExaminationType type, Patient patient, Doctor doctor) {	
		tx.begin();
		Examination examination= new Examination( type,patient,doctor);
		em.persist(examination);
		tx.commit();
		return examination;
	}
	
	public void delete(Examination examination) {
		tx.begin();
		
		em.remove(examination);
		
		tx.commit();
	}
	
	public void update(Examination examination) {
		tx.begin();
		
		em.merge(examination);
		
		tx.commit();
	}
	
	public Examination findByPrimaryKey(Long id) {
		tx.begin();
		
		Examination examination= em.find(Examination.class, id);
		
		tx.commit();
		
		return examination ;
	}
	
	public List<Examination> findAll() {
		tx.begin();
		Query query = em.createQuery("SELECT e FROM Esame e");
		tx.commit();
	    return (List<Examination>) query.getResultList();	
	}
	
}



