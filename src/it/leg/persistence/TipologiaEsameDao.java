package it.leg.persistence;

import java.util.List;

import it.leg.model.TipologiaEsame;


public interface TipologiaEsameDao {
	public void save(TipologiaEsame tipologiaEsame);
	public void delete(TipologiaEsame tipologiaEsame); 
	public void update(TipologiaEsame tipologiaEsame);
	TipologiaEsame findByPrimaryKey(Long id);
	List<TipologiaEsame> findAll();
}