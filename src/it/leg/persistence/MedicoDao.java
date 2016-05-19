package it.leg.persistence;

import java.util.List;

import it.leg.model.Doctor;


public interface MedicoDao {
	public void save(Doctor medico);
	public void delete(Doctor medico); 
	public void update(Doctor medico);
	Doctor findByPrimaryKey(Long id);
 	List<Doctor> findAll();
}
