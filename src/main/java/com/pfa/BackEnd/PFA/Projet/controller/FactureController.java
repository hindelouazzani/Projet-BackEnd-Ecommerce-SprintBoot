package com.pfa.BackEnd.PFA.Projet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.BackEnd.PFA.Projet.domaine.FactureVo;
import com.pfa.BackEnd.PFA.Projet.service.IServiceFacture;

@RestController
public class FactureController {


	@Autowired
	private IServiceFacture service; 

	/**
	 * Pour chercher tous les factures
	 */
	@GetMapping(value = "/rest/facture", produces = {MediaType.APPLICATION_JSON_VALUE }) 
	public List<FactureVo> getAll() { 
	 return service.getFactures(); 
	 } 
	
	/**
	 * Pour chercher un facture par son id
	 */
	@GetMapping(value = "/facture/{id}") 
	public ResponseEntity<Object> getFactureById(@PathVariable(value = "id") Long factureVoId) 
	{ 
		FactureVo factureVoFound = service.getFactureById(factureVoId); 
		if (factureVoFound == null) 
			return new ResponseEntity<>("facture doen't exist", HttpStatus.OK); 
		return new ResponseEntity<>(factureVoFound, HttpStatus.OK); 
	 } 
	
	/**
	 * Pour créer un nouveau facture
	 */
	@PostMapping(value = "/facture") 
	public ResponseEntity<Object> createFacture(@Valid @RequestBody FactureVo empVo) { 
		service.save(empVo); 
		return new ResponseEntity<>("facture is created successfully", HttpStatus.CREATED); 
	} 
	
	/**
	 * Pour modifier un facture par son id
	 */
	@PutMapping(value = "/facture/{id}") 
	public ResponseEntity<Object> updateFacture(@PathVariable(name = "id") Long factureVoId,@RequestBody FactureVo factureVo) { 
		FactureVo factureVoFound = service.getFactureById(factureVoId); 
		if (factureVoFound == null) 
		 	return new ResponseEntity<>("facture doen't exist", HttpStatus.OK); 
		factureVo.setId(factureVoId); 
	 	service.save(factureVo); 
	 	return new ResponseEntity<>("facture is updated successsfully", HttpStatus.OK); 
	}
	
	/**
	 * Pour chercher tous les factures
	 */
	@GetMapping(value = "/sortfacture/{fieldName}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE }) 
	public List<FactureVo> sortBy(@PathVariable String fieldName) { 
			return service.sortBy(fieldName); 
	 }
	
	/**
	 * Afficher la liste des factures en utilisant la pagination
	 */
	@GetMapping("/paginationfacture/{pageid}/{size}") 
	public List<FactureVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) { 
		return service.findAll(pageid, size); 
	 } 

}
