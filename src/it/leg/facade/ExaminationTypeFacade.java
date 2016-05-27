package it.leg.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;


public class ExaminationTypeFacade {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public ExaminationTypeFacade() {
		
	}
	
	public ExaminationType createExaminationType(String name, String description, Float cost) {	
		tx.begin();
		ExaminationType examinationType = new ExaminationType(name, description, cost);
		em.persist(examinationType);
		tx.commit();
		return examinationType;
	}
	
	public void delete(ExaminationType type) {
		tx.begin();
		
		em.remove(type);
		
		tx.commit();
	}
	
	public void update(ExaminationType type) {
		tx.begin();
		
		em.merge(type);
		
		tx.commit();
	}
	
	public ExaminationType findByPrimaryKey(String id) {
		tx.begin();
		
		ExaminationType type = em.find(ExaminationType.class, id);
		
		tx.commit();
		
		return type ;
	}
	
	public List<ExaminationType> findAll() {
		
		Query query = em.createQuery("SELECT e FROM ExaminationType e");
	    return (List<ExaminationType>) query.getResultList();	
	}
	 public ExaminationType find(String name){
		 tx.begin();
    	 ExaminationType type = em.find(ExaminationType.class,"name");
    	 tx.commit();
    	 return type;
     }

}
