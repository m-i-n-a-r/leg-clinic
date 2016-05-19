package it.leg.persistence;

import java.util.List;

import it.leg.model.Patient;;


public interface PazienteDao {
	public void save(Patient paziente);
	public void delete(Patient paziente); 
	public void update(Patient paziente);
	Patient findByPrimaryKey(Long id);
 	List<Patient> findAll();
}
