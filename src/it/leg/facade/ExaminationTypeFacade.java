package it.leg.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import it.leg.model.ExaminationType;


public class ExaminationTypeFacade {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public ExaminationType createExaminationType(String name, String description, Float cost) {	
		tx.begin();
		ExaminationType type= new ExaminationType(name,description,cost);
		em.persist(type);
		tx.commit();
		return type;
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
	
	public ExaminationType findByPrimaryKey(Long id) {
		tx.begin();
		
		ExaminationType type= em.find(ExaminationType.class, id);
		
		tx.commit();
		
		return type ;
	}
	
	public List<ExaminationType> findAll() {
		
		Query query = em.createQuery("SELECT e FROM tipologiaesame e");
	    return (List<ExaminationType>) query.getResultList();	
	}

}
