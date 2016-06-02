package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.Admin;
import it.leg.model.Doctor;
import it.leg.model.Patient;


@Stateless(name = "AdminFacade")
public class AdminFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;
	
	public Admin createAdmin(String firstName, String lastName, String email, String password) {
		Admin admin = new Admin(firstName, lastName, email, password);
		em.persist(admin);
		return admin;
	}

	public void delete(Admin admin){
		em.remove(admin);
	}
	public void update(Admin admin){
		em.merge(admin);
		
	}
	public Admin findByPrimaryKey(Long id){
		Admin admin = em.find(Admin.class, id);
		return admin;
		
	}
 	public List<Admin> findAll(){
 		Query query = em.createQuery("SELECT a FROM  Admin a");
	    return (List<Admin>) query.getResultList();	
 		
 	}
 	
	public Admin findByEmail(String email) {
		Query queryCF = em.createQuery("SELECT OBJECT(a) FROM Admin AS a WHERE a.email=?1");
		queryCF.setParameter(1, email);
		
		List<Admin> admins = queryCF.getResultList();
		if (admins.isEmpty()) {
			return null;
		} 
		else {
			Admin admin = (Admin) admins.get(0);
			return admin;
		}
	}
}


