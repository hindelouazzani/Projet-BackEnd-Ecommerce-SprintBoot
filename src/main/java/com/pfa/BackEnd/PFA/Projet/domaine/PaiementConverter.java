package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.ArrayList;
import java.util.List;

import com.pfa.BackEnd.PFA.Projet.service.model.Paiement;

public class PaiementConverter {

	
	public static PaiementVo toVo(Paiement bo){
		if (bo == null || bo.getId() ==null) 
			 return null; 
		PaiementVo vo=new PaiementVo();
		vo.setId(bo.getId());
		vo.setDatePaiement(bo.getDatePaiement());
		vo.setCreatedAt(bo.getCreatedAt());
		vo.setModePaiement(bo.getModePaiement());
		vo.setUpdatedAt(bo.getUpdatedAt());
		return vo;
		
	}
	
	public static Paiement toBO(PaiementVo vo){
		Paiement bo = new Paiement();
		bo.setId(vo.getId());
		bo.setDatePaiement(vo.getDatePaiement());
		bo.setCreatedAt(vo.getCreatedAt());
		bo.setModePaiement(vo.getModePaiement());
		bo.setUpdatedAt(vo.getUpdatedAt());
		return bo;
	}
	
	public static List<PaiementVo> toListVo(List<Paiement> listBo) { 
		 List<PaiementVo> listVo = new ArrayList<>(); 
		 for (Paiement paiement : listBo) { 
		 listVo.add(toVo(paiement)); 
		 } 
		 return listVo; 
		 } 
	
}