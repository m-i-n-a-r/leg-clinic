package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Esame;

public class EsameDaoJPA implements EsameDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(Esame esame) {	
		tx.begin();
		
		em.persist(esame);
		
		tx.commit();
	}
	
	public void delete(Esame esame) {
		tx.begin();
		
		em.remove(esame);
		
		tx.commit();
	}
	
	public void update(Esame esame) {
		tx.begin();
		
		em.merge(esame);
		
		tx.commit();
	}
	
	public Esame findByPrimaryKey(Long id) {
		tx.begin();
		
		Esame esame = em.find(Esame.class, id);
		
		tx.commit();
		
		return esame;
	}
	
	public List<Esame> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<Esame>) query.getResultList();	
	}
	
	
}