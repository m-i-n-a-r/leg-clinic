package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Medico;

public class MedicoDaoJPA implements MedicoDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(Medico medico) {	
		tx.begin();
		
		em.persist(medico);
		
		tx.commit();
	}
	
	public void delete(Medico medico) {
		tx.begin();
		
		em.remove(medico);
		
		tx.commit();
	}
	
	public void update(Medico medico) {
		tx.begin();
		
		em.merge(medico);
		
		tx.commit();
	}
	
	public Medico findByPrimaryKey(Long id) {
		tx.begin();
		
		Medico medico = em.find(Medico.class, id);
		
		tx.commit();
		
		return medico;
	}
	
	public List<Medico> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<Medico>) query.getResultList();	
	}
	
	
}