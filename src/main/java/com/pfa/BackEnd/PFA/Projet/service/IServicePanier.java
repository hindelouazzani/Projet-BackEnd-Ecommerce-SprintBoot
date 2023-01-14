package com.pfa.BackEnd.PFA.Projet.service;

import java.util.Date;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.domaine.PanierVo;

public interface IServicePanier {
	List<PanierVo> getPaniers();
	void save(PanierVo panier);
	PanierVo getPanierById(Long id);
	void delete(Long id);
	List<PanierVo> findByQuantite(int q);
	List<PanierVo> findByPrixTotal(float prixtotal);
	List<PanierVo> findByDate(Date d);
	List<PanierVo> findByCreatedAt(Date d);
	List<PanierVo> findByUpdatedAt(Date d );
	List<PanierVo> findAll(int pageId, int size); 
	//pour le tri
	 List<PanierVo> sortBy(String fieldName); 

	
	

}
