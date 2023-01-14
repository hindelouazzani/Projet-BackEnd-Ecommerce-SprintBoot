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

import com.pfa.BackEnd.PFA.Projet.dao.FactureRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.FactureConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.FactureVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Facture;

@Service
public class ServiceFacture implements CommandLineRunner, IServiceFacture {

	@Autowired
	private FactureRepository factureRepository;
	@Override
	public List<FactureVo> getFactures() {
		List<Facture> list = factureRepository.findAll(); 
		 return FactureConverter.toListVo(list); 
	}

	@Override
	public void save(FactureVo facture) {
		factureRepository.save(FactureConverter.toBo(facture)); 
	}

	@SuppressWarnings("deprecation")
	@Override
	public FactureVo getFactureById(Long id) {
		boolean trouve = factureRepository.existsById(id); 
		 if (!trouve) 
			 return null; 
		 return FactureConverter.toVo(factureRepository.getOne(id)); 
	}

	@Override
	public void delete(Long id) {
		factureRepository.deleteById(id);
	}

	@Override
	public List<FactureVo> findByDateFacture(Date d) {
		List<Facture> list = factureRepository.findByDateFacture(d); 
		 return FactureConverter.toListVo(list);		
	}

	@Override
	public List<FactureVo> findByTotalFacture(Facture f) {
		List<Facture> list = factureRepository.findByTotalFacture(f); 
		 return FactureConverter.toListVo(list);
	}

	@Override
	public List<FactureVo> findByCreatedAt(Date d) {
		List<Facture> list = factureRepository.findByCreatedAt(d); 
		 return FactureConverter.toListVo(list);
	}

	@Override
	public List<FactureVo> findByUpdatedAt(Date d) {
		List<Facture> list = factureRepository.findByUpdatedAt(d); 
		 return FactureConverter.toListVo(list);
	}

	@Override
	public List<FactureVo> findAll(int pageId, int size) {
		Page<Facture> result = factureRepository.findAll(PageRequest.of(pageId, size, 
				Direction.ASC, "name")); 
				 return FactureConverter.toListVo(result.getContent()); 
	}

	@Override
	public List<FactureVo> sortBy(String fieldName) {
		 return FactureConverter.toListVo(factureRepository.findAll(Sort.by(fieldName))); 

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Pacture " );
	}

}
