package it.leg.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.leg.model.Admin;



public class AdminFacade {

	public AdminFacade(){}
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	public Admin createAdmin(String firstName, String lastName, String email, String password) {
		tx.begin();
		Admin admin = new Admin(firstName,lastName,email,password);
		em.persist(admin);
		tx.commit();
		return admin;
	}

	public void delete(Admin admin){
		tx.begin();
		em.remove(admin);
		tx.commit();
	}
	public void update(Admin admin){
		tx.begin();
		em.merge(admin);
		tx.commit();
		
	}
	public Admin findByPrimaryKey(Long id){
		tx.begin();
		Admin admin = em.find(Admin.class, id);
		tx.commit();
		return admin;
		
	}
 	public List<Admin> findAll(){
 		tx.begin();
 		Query query = em.createQuery("SELECT a FROM  Admin a");
 		tx.commit();
	    return (List<Admin>) query.getResultList();	
 		
 	}
}


