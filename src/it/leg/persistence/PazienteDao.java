package it.leg.persistence;

import java.util.List;

import it.leg.model.Paziente;;


public interface PazienteDao {
	public void save(Paziente paziente);
	public void delete(Paziente paziente); 
	public void update(Paziente paziente);
	Paziente findByPrimaryKey(Long id);
 	List<Paziente> findAll();
}
