package it.leg.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.leg.model.Condition;
import it.leg.model.Doctor;
import it.leg.model.ExaminationType;

@Stateless(name="ConditionFacade")
public class ConditionFacade {
	
	
	@PersistenceContext(unitName = "legClinic")
	private EntityManager em;

	public Condition createCondition(String name,String description) {
		Condition condition = new Condition(name,description);
		em.persist(condition);
		return condition;
	}

	public void delete(Condition condition){
		em.remove(condition);
	}
	
	public void update(Condition condition){
		em.merge(condition);
	}
	
	public Condition findByPrimaryKey(String name){
		Condition condition = em.find(Condition.class, name);
		return condition;
	}
	
	public List<Condition> findAll(){
		Query query = em.createQuery("SELECT c FROM  Condition c");
		return (List<Condition>) query.getResultList();	
	}
	
	public Condition find(String name){
		Condition condition= em.find(Condition.class, name);
		return condition;
	}

}



