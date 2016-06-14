package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;

import it.leg.model.Doctor;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;

@Stateless(name = "ExaminationFacade")
public class ExaminationFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;
	
	public Examination createExamination(Examination examination) {	
		em.persist(examination);
		return examination;
	}
	
	public void delete(Examination examination) {
		em.remove(examination);
	}
	
	public void update(Examination examination) {
		em.merge(examination);
	}
	
	public Examination findByPrimaryKey(Long id) {
		Examination examination = em.find(Examination.class, id);
		return examination;
	}
	
	public List<Examination> findAll() {
		Query query = em.createQuery("SELECT e FROM Examination e");
	    return (List<Examination>) query.getResultList();	
	}
	

	public List<Examination> findAllExamsByDoctor(Doctor doctor) {
		Query q = em.createQuery("SELECT OBJECT(ep) FROM Examination AS ep WHERE ep.doctor=?1");
		q.setParameter(1, doctor);
		List<Examination> exams = q.getResultList();
		return exams;
	}
	
	public List<Examination> findAllbyId(Long id) {
	    
		Query query = em.createQuery("SELECT e FROM Examination AS e WHERE patient_id="+id);
	    
	   	    List<Examination> examinations = query.getResultList();
	    
	      return examinations;
	    }
	
}



