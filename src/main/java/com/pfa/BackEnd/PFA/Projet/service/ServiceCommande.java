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

import com.pfa.BackEnd.PFA.Projet.dao.CommandeRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.CommandeConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.CommandeVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Commande;

@Service
public class ServiceCommande implements IServiceCommande, CommandLineRunner {


	@Autowired
	private CommandeRepository commandeRepository;
	
	
	@Override
	public List<CommandeVo> getCommandes() {
		List<Commande> list = commandeRepository.findAll(); 
		 return CommandeConverter.toListVo(list);
	}

	@Override
	public void save(CommandeVo commande) {
		commandeRepository.save(CommandeConverter.toBo(commande)); 		
	}

	@SuppressWarnings("deprecation")
	@Override
	public CommandeVo getCommandeById(Long id) {
		boolean trouve = commandeRepository.existsById(id); 
		 if (!trouve) 
			 return null; 
		 return CommandeConverter.toVo(commandeRepository.getOne(id)); 
	}

	@Override
	public void delete(Long id) {
		commandeRepository.deleteById(id); 
	}

	@Override
	public List<CommandeVo> findBySommeTotal(float s) {
		List<Commande> list = commandeRepository.findBySommeTotal(s); 
		 return CommandeConverter.toListVo(list); 
	}

	@Override
	public List<CommandeVo> findByQuantite(int q) {
		List<Commande> list = commandeRepository.findByQuantite(q); 
		 return CommandeConverter.toListVo(list); 
	}

	@Override
	public List<CommandeVo> findByDateCommande(Date d) {
		List<Commande> list = commandeRepository.findByDateCommande(d); 
		 return CommandeConverter.toListVo(list); 
	}

	@Override
	public List<CommandeVo> findByCreatedAt(Date d) {
		List<Commande> list = commandeRepository.findByCreatedAt(d); 
		 return CommandeConverter.toListVo(list); 
	}

	@Override
	public List<CommandeVo> findByUpdatedAt(Date d) {
		List<Commande> list = commandeRepository.findByUpdatedAt(d); 
		 return CommandeConverter.toListVo(list); 
	}

	@Override
	 public  List<CommandeVo> findAll(int pageId, int size) { 
			 Page<Commande> result = commandeRepository.findAll(PageRequest.of(pageId, size, 
			Direction.ASC, "name")); 
			 return CommandeConverter.toListVo(result.getContent());
	}

	@Override
	public List<CommandeVo> sortBy(String fieldName) {
		 return CommandeConverter.toListVo(commandeRepository.findAll(Sort.by(fieldName))); 

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Commandes: " );		
	}

}
