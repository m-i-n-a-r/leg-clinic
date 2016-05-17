package it.leg.persistence;

import java.util.List;

import it.leg.model.Medico;


public interface MedicoDao {
	public void save(Medico medico);
	public void delete(Medico medico); 
	public void update(Medico medico);
	Medico findByPrimaryKey(Long id);
 	List<Medico> findAll();
}
