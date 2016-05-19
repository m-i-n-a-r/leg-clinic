package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Examination;

public class EsameDaoJPA implements EsameDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(Examination esame) {	
		tx.begin();
		
		em.persist(esame);
		
		tx.commit();
	}
	
	public void delete(Examination esame) {
		tx.begin();
		
		em.remove(esame);
		
		tx.commit();
	}
	
	public void update(Examination esame) {
		tx.begin();
		
		em.merge(esame);
		
		tx.commit();
	}
	
	public Examination findByPrimaryKey(Long id) {
		tx.begin();
		
		Examination esame = em.find(Examination.class, id);
		
		tx.commit();
		
		return esame;
	}
	
	public List<Examination> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<Examination>) query.getResultList();	
	}
	
	
}