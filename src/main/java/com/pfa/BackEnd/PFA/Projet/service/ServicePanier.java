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

import com.pfa.BackEnd.PFA.Projet.dao.PanierRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.PanierConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.PanierVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Panier;

@Service
public class ServicePanier implements CommandLineRunner, IServicePanier {

	@Autowired
	private PanierRepository panierRepository;
	

	@Override
	public List<PanierVo> getPaniers() {
		List<Panier> list = panierRepository.findAll(); 
		 return PanierConverter.toListVo(list); 

	}

	@Override
	public void save(PanierVo panier) {
		panierRepository.save(PanierConverter.toBo(panier));
	}

	@SuppressWarnings("deprecation")
	@Override
	public PanierVo getPanierById(Long id) {
		boolean trouve = panierRepository.existsById(id); 
		 if (!trouve) 
			 return null; 
		 return PanierConverter.toVo(panierRepository.getOne(id)); 

	}

	@Override
	public void delete(Long id) {
		panierRepository.deleteById(id);
	}

	@Override
	public List<PanierVo> findByQuantite(int q) {
		List<Panier> list = panierRepository.findByQuantite(q); 
		 return PanierConverter.toListVo(list); 

	}

	@Override
	public List<PanierVo> findByPrixTotal(float prixtotal) {
		List<Panier> list = panierRepository.findByPrixTotal(prixtotal); 
		 return PanierConverter.toListVo(list); 
	}

	@Override
	public List<PanierVo> findByDate(Date d) {
		List<Panier> list = panierRepository.findByDate(d); 
		 return PanierConverter.toListVo(list); 
	}

	@Override
	public List<PanierVo> findByCreatedAt(Date d) {
		List<Panier> list = panierRepository.findByCreatedAt(d); 
		 return PanierConverter.toListVo(list); 
	}

	@Override
	public List<PanierVo> findByUpdatedAt(Date d) {
		List<Panier> list = panierRepository.findByUpdatedAt(d); 
		 return PanierConverter.toListVo(list); 
	}

	@Override
	public List<PanierVo> findAll(int pageId, int size) {
		Page<Panier> result = panierRepository.findAll(PageRequest.of(pageId, size, 
				Direction.ASC, "name")); 
				 return PanierConverter.toListVo(result.getContent()); 

	}

	@Override
	public List<PanierVo> sortBy(String fieldName) {
		 return PanierConverter.toListVo(panierRepository.findAll(Sort.by(fieldName))); 
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Paniers: " );
		
	}

}
