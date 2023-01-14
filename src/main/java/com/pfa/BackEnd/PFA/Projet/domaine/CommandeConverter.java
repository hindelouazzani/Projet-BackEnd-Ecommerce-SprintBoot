package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.ArrayList;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.service.model.Commande;

public class CommandeConverter {

	public static CommandeVo toVo(Commande bo){
		if(bo == null || bo.getId() == null)
			return null;
		CommandeVo vo =new CommandeVo();
		vo.setId(bo.getId());
		vo.setCreatedAt(bo.getCreatedAt());
		vo.setDateCommande(bo.getDateCommande());		
		vo.setSommeTotal(bo.getSommeTotal());
		vo.setUpdatedAt(bo.getUpdatedAt());
		vo.setQuantite(bo.getQuantite());
		return vo;
	}
	
	public static Commande toBo(CommandeVo vo){
		Commande bo = new Commande();
		bo.setId(vo.getId());
		bo.setCreatedAt(vo.getCreatedAt());
		bo.setDateCommande(vo.getDateCommande());		
		bo.setSommeTotal(vo.getSommeTotal());
		bo.setUpdatedAt(vo.getUpdatedAt());
		bo.setQuantite(vo.getQuantite());
		return bo;
	
	}
	
	public static List<CommandeVo> toListVo(List<Commande> listBo) { 
		 List<CommandeVo> listVo = new ArrayList<>(); 
		 for (Commande commande : listBo) { 
		 listVo.add(toVo(commande)); 
		 } 
		 return listVo; 
		 } 

	
	
	
}
