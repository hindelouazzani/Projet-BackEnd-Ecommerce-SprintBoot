package com.pfa.BackEnd.PFA.Projet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.BackEnd.PFA.Projet.domaine.CommandeVo;
import com.pfa.BackEnd.PFA.Projet.service.IServiceCommande;

@RestController
public class CommandeController {

	@Autowired
	private IServiceCommande service; 
	
	/**
	 * Pour chercher tous les commande
	 */
	@GetMapping(value = "/commande", produces = {MediaType.APPLICATION_JSON_VALUE }) 
	public List<CommandeVo> getAll() { 
	 return service.getCommandes(); 
	 } 
	
	/**
	 * Pour chercher un commande par son id
	 */
	@GetMapping(value = "/commande/{id}") 
	public ResponseEntity<Object> getCommandeById(@PathVariable(value = "id") Long commandeVoId) 
	{ 
		CommandeVo commandeVoFound = service.getCommandeById(commandeVoId); 
		if (commandeVoFound == null) 
		 	return new ResponseEntity<>("commande doen't exist", HttpStatus.OK); 
		return new ResponseEntity<>(commandeVoFound, HttpStatus.OK); 
	 } 

	
	/**
	 * Pour créer un nouveau employé
	 */
	@PostMapping(value = "/commande") 
	public ResponseEntity<Object> createCommande(@Valid @RequestBody CommandeVo commandeVo) { 
		service.save(commandeVo);
		return new ResponseEntity<>("commande is created successfully", HttpStatus.CREATED); 
	} 
	
	/**
	 * Pour modifier un produit par son id
	 */
	@PutMapping(value = "/commande/{id}") 
	public ResponseEntity<Object> updateCommande(@PathVariable(name = "id") Long commandeVoId, 
	@RequestBody CommandeVo empVo) { 
			CommandeVo commandeVoFound = service.getCommandeById(commandeVoId); 
			if (commandeVoFound == null) 
				return new ResponseEntity<>("employee doen't exist", HttpStatus.OK); 
			empVo.setId(commandeVoId); 
			service.save(empVo); 
			return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK); 
	 } 
	
	/**
	 * Pour supprimer un commande par son id
	 */
	@DeleteMapping(value = "/commande/{id}") 
	public ResponseEntity<Object> deleteCommande(@PathVariable(name = "id") Long commandeVoId) { 
		CommandeVo commandeVoFound = service.getCommandeById(commandeVoId); 
		if (commandeVoFound == null) 
			return new ResponseEntity<>("commande doen't exist", HttpStatus.OK); 
		service.delete(commandeVoId); 
		return new ResponseEntity<>("commande is deleted successsfully", HttpStatus.OK); 
	 } 
	
	/**
	 * Pour chercher tous les commandes
	 */
	@GetMapping(value = "/rest/sortcommande/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public List<CommandeVo> sortBy(@PathVariable String fieldName) { 
		return service.sortBy(fieldName); 
	}
	
	/**
	 * Afficher la liste des commandes en utilisant la pagination
	 */
	@GetMapping("/rest/paginationcommande/{pageid}/{size}") 
	public List<CommandeVo> pagination(@PathVariable int pageid, @PathVariable int size, 
	Model m) { 
	 return service.findAll(pageid, size); 
	 } 

	
	
	
}
