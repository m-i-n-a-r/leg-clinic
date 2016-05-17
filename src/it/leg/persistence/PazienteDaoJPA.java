package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Paziente;

public class PazienteDaoJPA implements PazienteDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(Paziente paziente) {	
		tx.begin();
		
		em.persist(paziente);
		
		tx.commit();
	}
	
	public void delete(Paziente paziente) {
		tx.begin();
		
		em.remove(paziente);
		
		tx.commit();
	}
	
	public void update(Paziente paziente) {
		tx.begin();
		
		em.merge(paziente);
		
		tx.commit();
	}
	
	public Paziente findByPrimaryKey(Long id) {
		tx.begin();
		
		Paziente paziente = em.find(Paziente.class, id);
		
		tx.commit();
		
		return paziente;
	}
	
	public List<Paziente> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<Paziente>) query.getResultList();	
	}
	
	
}