package com.pfa.BackEnd.PFA.Projet.service;

import java.util.Date;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.domaine.CommandeVo;

public interface IServiceCommande {
	
	List<CommandeVo> getCommandes();
	void save(CommandeVo commande);
	CommandeVo getCommandeById(Long id);
	void delete(Long id);
	List<CommandeVo> findBySommeTotal(float s);
	List<CommandeVo> findByQuantite(int q);
	List<CommandeVo> findByDateCommande(Date d);
	List<CommandeVo> findByCreatedAt(Date d);
	List<CommandeVo> findByUpdatedAt(Date d);
	List<CommandeVo> findAll(int pageId, int size);
	//pour le tri
	 List<CommandeVo> sortBy(String fieldName); 

}
