package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Patient;

public class PazienteDaoJPA implements PazienteDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(Patient paziente) {	
		tx.begin();
		
		em.persist(paziente);
		
		tx.commit();
	}
	
	public void delete(Patient paziente) {
		tx.begin();
		
		em.remove(paziente);
		
		tx.commit();
	}
	
	public void update(Patient paziente) {
		tx.begin();
		
		em.merge(paziente);
		
		tx.commit();
	}
	
	public Patient findByPrimaryKey(Long id) {
		tx.begin();
		
		Patient paziente = em.find(Patient.class, id);
		
		tx.commit();
		
		return paziente;
	}
	
	public List<Patient> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<Patient>) query.getResultList();	
	}
	
	
}