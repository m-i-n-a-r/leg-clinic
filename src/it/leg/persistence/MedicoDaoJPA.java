package it.leg.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Doctor;

public class MedicoDaoJPA implements MedicoDao {
	// Creo l'entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public void save(Doctor medico) {	
		tx.begin();
		
		em.persist(medico);
		
		tx.commit();
	}
	
	public void delete(Doctor medico) {
		tx.begin();
		
		em.remove(medico);
		
		tx.commit();
	}
	
	public void update(Doctor medico) {
		tx.begin();
		
		em.merge(medico);
		
		tx.commit();
	}
	
	public Doctor findByPrimaryKey(Long id) {
		tx.begin();
		
		Doctor medico = em.find(Doctor.class, id);
		
		tx.commit();
		
		return medico;
	}
	
	public List<Doctor> findAll() {
		
		Query query = em.createQuery("SELECT e FROM Order e");
	    return (List<Doctor>) query.getResultList();	
	}
	
	
}