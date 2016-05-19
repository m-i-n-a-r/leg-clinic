package it.leg.persistence;

import java.util.List;

import it.leg.model.Examination;

//prova
public interface EsameDao {
	public void save(Examination esame);
	public void delete(Examination esame); 
	public void update(Examination esame);
	Examination findByPrimaryKey(Long id);
 	List<Examination> findAll();
}