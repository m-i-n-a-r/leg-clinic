package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.Condition;
import it.leg.model.ExaminationType;


@Stateless(name = "ExaminationTypeFacade")
public class ExaminationTypeFacade {

	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;

	public ExaminationType createExaminationType(String name, String description, Float cost){	
		ExaminationType examinationType = new ExaminationType(name, description, cost);
		em.persist(examinationType);
		return examinationType;
	}

	public void delete(ExaminationType type) {
		em.remove(type);
	}

	public void update(ExaminationType type) {
		em.merge(type);
	}

	public ExaminationType findByPrimaryKey(String id) {
		ExaminationType type = em.find(ExaminationType.class, id);
		return type ;
	}

	public List<ExaminationType> findAll() {
		Query query = em.createQuery("SELECT e FROM ExaminationType e");
		return (List<ExaminationType>) query.getResultList();	
	}
	
	public ExaminationType find(String name){
		ExaminationType type = em.find(ExaminationType.class, "name");
		return type;
	}
	public List<Condition> addCondition(ExaminationType type, Condition condition) {
		List<Condition> preconditions = type.getPreconditions();
		
		preconditions.add(condition);
		
		type.setPreconditions(preconditions);
		
		return preconditions;
	}
}
