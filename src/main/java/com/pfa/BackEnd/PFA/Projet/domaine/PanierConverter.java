package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.ArrayList;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.service.model.Panier;


public class PanierConverter {

	public static PanierVo toVo(Panier bo){
		if(bo == null || bo.getId() == null )
			return null ; 
		PanierVo vo = new PanierVo();
		vo.setId(bo.getId());
		vo.setDate(bo.getDate());
		vo.setCreatedAt(bo.getCreatedAt());
		vo.setPrixTotal(bo.getPrixTotal());
		vo.setQuantite(bo.getQuantite());
		vo.setUpdatedAt(bo.getUpdatedAt());
		return vo;
	}
	
	public static Panier toBo(PanierVo vo){
		Panier bo = new Panier();
		bo.setId(vo.getId());
		bo.setDate(vo.getDate());
		bo.setCreatedAt(vo.getCreatedAt());
		bo.setPrixTotal(vo.getPrixTotal());
		bo.setQuantite(vo.getQuantite());
		bo.setUpdatedAt(vo.getUpdatedAt());
		return bo;
	}
	
	public static List<PanierVo> toListVo(List<Panier> listBo){
		List<PanierVo> listVo = new ArrayList<>(); 
		 for (Panier panier : listBo) { 
			 listVo.add(toVo(panier)); 
		 } 
		 return listVo; 
	}

}
