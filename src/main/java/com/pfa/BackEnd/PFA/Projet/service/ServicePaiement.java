package com.pfa.BackEnd.PFA.Projet.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pfa.BackEnd.PFA.Projet.dao.PaiementRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.PaiementConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.PaiementVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Paiement;

@Service
public class ServicePaiement implements CommandLineRunner, IServicePaiement {


	@Autowired
	private PaiementRepository paiementRepository;
	@Override
	public List<PaiementVo> getPaiement() {
		List<Paiement> list = paiementRepository.findAll(); 
		 return PaiementConverter.toListVo(list); 
	}

	@Override
	public void save(PaiementVo paiement) {
		paiementRepository.save(PaiementConverter.toBO(paiement)); 
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public PaiementVo getPaiementById(Long id) {
		boolean trouve = paiementRepository.existsById(id); 
		 if (!trouve) 
			 return null; 
		 return PaiementConverter.toVo(paiementRepository.getOne(id)); 
	}

	@Override
	public void delete(Long id) {
		paiementRepository.deleteById(id);		
	}

	@Override
	public List<PaiementVo> findByModePaiement(String modePaiement) {
		List<Paiement> list = paiementRepository.findByModePaiement(modePaiement); 
		 return PaiementConverter.toListVo(list); 
	}

	@Override
	public List<PaiementVo> findByDatePaiement(Date datePaiement) {
		List<Paiement> list = paiementRepository.findByDatePaiement(datePaiement); 
		 return PaiementConverter.toListVo(list); 
	}

	@Override
	public List<PaiementVo> findByCreatedAt(Date d) {
		List<Paiement> list = paiementRepository.findByCreatedAt(d); 
		 return PaiementConverter.toListVo(list); 
	}

	@Override
	public List<PaiementVo> findByUpdatedAt(Date d) {
		List<Paiement> list = paiementRepository.findByUpdatedAt(d); 
		 return PaiementConverter.toListVo(list); 
	}

	@Override
	public List<PaiementVo> findAll(int pageId, int size) {
		Page<Paiement> result = paiementRepository.findAll(PageRequest.of(pageId, size, 
				Direction.ASC, "name")); 
				 return PaiementConverter.toListVo(result.getContent()); 

	}

	@Override
	public List<PaiementVo> sortBy(String fieldName) {
		 return PaiementConverter.toListVo(paiementRepository.findAll(Sort.by(fieldName))); 

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("service Paiement: ");
			
	}

}
