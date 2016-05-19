package it.leg.persistence;

import java.util.List;

import it.leg.model.ExaminationType;


public interface TipologiaEsameDao {
	public void save(ExaminationType tipologiaEsame);
	public void delete(ExaminationType tipologiaEsame); 
	public void update(ExaminationType tipologiaEsame);
	ExaminationType findByPrimaryKey(Long id);
	List<ExaminationType> findAll();
}