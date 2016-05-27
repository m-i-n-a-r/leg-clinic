package it.leg.facade;


	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	
    import it.leg.model.Doctor;
import it.leg.model.Patient;


		public class DoctorFacade{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		public Doctor createDoctor(String name, String surname, String specialization) {
			tx.begin();
			Doctor doctor=new Doctor(name,surname,specialization);
			em.persist(doctor);
			tx.commit();
			return doctor;
		}

		public void delete(Doctor doctor){
			tx.begin();
			em.remove(doctor);
			tx.commit();
		}
		public void update(Doctor doctor){
			tx.begin();
			em.merge(doctor);
			tx.commit();
			
		}
		public Doctor findByPrimaryKey(Long id){
			tx.begin();
			Doctor doctor = em.find(Doctor.class, id);
			tx.commit();
			return doctor;
			
		}
	 	public List<Doctor> findAll(){
	 		tx.begin();
	 		Query query = em.createQuery("SELECT d FROM  Doctor d");
	 		tx.commit();
		    return (List<Doctor>) query.getResultList();	
	 		
	 	}
	 	 public Doctor find(String name){
	 		 tx.begin();
	    	 Doctor doctor= em.find(Doctor.class, name);
	    	 tx.commit();
	    	 return doctor;
	     }

}
