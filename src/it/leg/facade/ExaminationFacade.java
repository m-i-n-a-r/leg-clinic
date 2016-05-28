package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.Doctor;
import it.leg.model.Examination;
import it.leg.model.ExaminationType;
import it.leg.model.Patient;

@Stateless(name = "ExaminationFacade")
public class ExaminationFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;
	
	public Examination createExamination(ExaminationType type, Patient patient, Doctor doctor) {	
		Examination examination= new Examination( type,patient,doctor);
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
		Examination examination= em.find(Examination.class, id);
		return examination ;
	}
	
	public List<Examination> findAll() {
		Query query = em.createQuery("SELECT e FROM Esame e");
	    return (List<Examination>) query.getResultList();	
	}
	
}



