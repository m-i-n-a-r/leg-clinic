package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.ExaminationType;

public class TipologiaEsameDaoJPA implements TipologiaEsameDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(ExaminationType tipologiaEsame) {	
		tx.begin();
		
		em.persist(tipologiaEsame);
		
		tx.commit();
	}
	
	public void delete(ExaminationType tipologiaEsame) {
		tx.begin();
		
		em.remove(tipologiaEsame);
		
		tx.commit();
	}
	
	public void update(ExaminationType tipologiaEsame) {
		tx.begin();
		
		em.merge(tipologiaEsame);
		
		tx.commit();
	}
	
	public ExaminationType findByPrimaryKey(Long id) {
		tx.begin();
		
		ExaminationType tipologiaEsame = em.find(ExaminationType.class, id);
		
		tx.commit();
		
		return tipologiaEsame;
	}
	
	public List<ExaminationType> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<ExaminationType>) query.getResultList();	
	}
	
	
}