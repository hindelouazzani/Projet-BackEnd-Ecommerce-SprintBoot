package com.pfa.BackEnd.PFA.Projet.service;

import java.util.Date;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.domaine.FactureVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Facture;

public interface IServiceFacture {

	List<FactureVo> getFactures();
	void save(FactureVo facture);
	FactureVo getFactureById(Long id);
	void delete(Long id);
	List<FactureVo> findByDateFacture(Date d);
	List<FactureVo> findByTotalFacture(Facture f);
	List<FactureVo> findByCreatedAt(Date d);
	List<FactureVo> findByUpdatedAt(Date d );
	//Pour la pagination
	 List<FactureVo> findAll(int pageId, int size); 
	//pour le tri
	 List<FactureVo> sortBy(String fieldName); 
}
