package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.ArrayList;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.service.model.Facture;

public class FactureConverter {

	public static FactureVo toVo(Facture bo){
		if(bo == null || bo.getId()==null)
			return null;
		FactureVo vo= new FactureVo();
		vo.setCreatedAt(bo.getCreatedAt());
		vo.setDateFacture(bo.getDateFacture());
		vo.setId(bo.getId());
		vo.setTotalFacture(bo.getTotalFacture());
		vo.setUpdatedAt(bo.getUpdatedAt());
		return vo;
	}
	
	public static Facture toBo(FactureVo vo){
		Facture bo = new Facture();
		bo.setCreatedAt(vo.getCreatedAt());
		bo.setDateFacture(vo.getDateFacture());
		bo.setId(vo.getId());
		bo.setTotalFacture(vo.getTotalFacture());
		bo.setUpdatedAt(vo.getUpdatedAt());
		return bo;
	}
	
	public static List<FactureVo> toListVo(List<Facture> listBo) { 
		 List<FactureVo> listVo = new ArrayList<>(); 
		 for (Facture facture : listBo) { 
		 listVo.add(toVo(facture)); 
		 } 
		 return listVo; 
		 } 
}
