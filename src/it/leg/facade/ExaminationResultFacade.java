package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.ExaminationResult;

@Stateless(name = "ExaminationResultFacade")
public class ExaminationResultFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;
	
	public ExaminationResult createExaminationResult(String name, String value) {	
		ExaminationResult examinationResult = new ExaminationResult(name, value);
		em.persist(examinationResult);
		return examinationResult;
	}
	
	public void delete(ExaminationResult examinationResult) {
		em.remove(examinationResult);
	}
	
	public void update(ExaminationResult examinationResult) {
		em.merge(examinationResult);
	}
	
	public ExaminationResult findByPrimaryKey(Long id) {
		ExaminationResult examinationResult = em.find(ExaminationResult.class, id);
		return examinationResult ;
	}
	
	public List<ExaminationResult> findAll() {
		Query query = em.createQuery("SELECT e FROM Esame e");
	    return (List<ExaminationResult>) query.getResultList();	
	}
	
}