package com.pfa.BackEnd.PFA.Projet.service;

import java.util.Date;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.domaine.PaiementVo;

public interface IServicePaiement {

	List<PaiementVo> getPaiement();
	void save(PaiementVo paiement);
	PaiementVo getPaiementById(Long id);
	void delete(Long id);
	List<PaiementVo> findByModePaiement(String modePaiement);
	List<PaiementVo> findByDatePaiement(Date datePaiement);
	List<PaiementVo> findByCreatedAt(Date d);
	List<PaiementVo> findByUpdatedAt(Date d );
	//Pour la pagination
	 List<PaiementVo> findAll(int pageId, int size); 
	//pour le tri
	 List<PaiementVo> sortBy(String fieldName); 
	
	
	
}
