package it.leg.persistence;

import java.util.List;

import it.leg.model.Esame;

//prova
public interface EsameDao {
	public void save(Esame esame);
	public void delete(Esame esame); 
	public void update(Esame esame);
	Esame findByPrimaryKey(Long id);
 	List<Esame> findAll();
}