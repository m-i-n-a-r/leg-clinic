package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.TipologiaEsame;

public class TipologiaEsameDaoJPA implements TipologiaEsameDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(TipologiaEsame tipologiaEsame) {	
		tx.begin();
		
		em.persist(tipologiaEsame);
		
		tx.commit();
	}
	
	public void delete(TipologiaEsame tipologiaEsame) {
		tx.begin();
		
		em.remove(tipologiaEsame);
		
		tx.commit();
	}
	
	public void update(TipologiaEsame tipologiaEsame) {
		tx.begin();
		
		em.merge(tipologiaEsame);
		
		tx.commit();
	}
	
	public TipologiaEsame findByPrimaryKey(Long id) {
		tx.begin();
		
		TipologiaEsame tipologiaEsame = em.find(TipologiaEsame.class, id);
		
		tx.commit();
		
		return tipologiaEsame;
	}
	
	public List<TipologiaEsame> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<TipologiaEsame>) query.getResultList();	
	}
	
	
}