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

import com.pfa.BackEnd.PFA.Projet.domaine.PaiementVo;
import com.pfa.BackEnd.PFA.Projet.service.IServicePaiement;

@RestController
public class PaiementController {
	
	@Autowired
	private IServicePaiement service;
	
	/**
	 * Pour chercher tous les paiements
	 */
	@GetMapping(value = "/paiement", produces = {MediaType.APPLICATION_JSON_VALUE }) 
	public List<PaiementVo> getAll() { 
		return service.getPaiement();
	} 

	/**
	 * Pour chercher un paiement par son id
	 */
	@GetMapping(value = "/paiement/{id}") 
	public ResponseEntity<Object> getPaiementById(@PathVariable(value = "id") Long paiementVoId) 
	{ 
	 PaiementVo paiementVoFound = service.getPaiementById(paiementVoId); 
	 if (paiementVoFound == null) 
		 return new ResponseEntity<>("employee doen't exist", HttpStatus.OK); 
	 return new ResponseEntity<>(paiementVoFound, HttpStatus.OK); 
	 } 
	
	/**
	 * Pour créer un nouveau paiement
	 */
	@PostMapping(value = "/paiement") 
	public ResponseEntity<Object> createPaiement(@Valid @RequestBody PaiementVo paiementVo) { 
		service.save(paiementVo); 
		return new ResponseEntity<>("employee is created successfully", HttpStatus.CREATED); 
	}
	
	/**
	 * Pour modifier un paiement par son id
	 */
	@PutMapping(value = "/paiement/{id}") 
	public ResponseEntity<Object> updatePaiement(@PathVariable(name = "id") Long paiementVoId, @RequestBody PaiementVo paiementVo) { 
		PaiementVo empVoFound = service.getPaiementById(paiementVoId); 
		if (empVoFound == null) 
			return new ResponseEntity<>("paiement doen't exist", HttpStatus.OK); 
		paiementVo.setId(paiementVoId); 
		service.save(paiementVo); 
		return new ResponseEntity<>("paiement is updated successsfully", HttpStatus.OK); 
	 } 
	/**
	 * Pour chercher tous les paiements
	 */
	@GetMapping(value = "/sortpaiement/{fieldName}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public List<PaiementVo> sortBy(@PathVariable String fieldName) { 
	 return service.sortBy(fieldName); 
	 } 
	/**
	 * Afficher la liste des paiements en utilisant la pagination
	 */
	@GetMapping("/paginationpaiement/{pageid}/{size}") 
	public List<PaiementVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) { 
		return  service.findAll(pageid, size); 
	} 
	


	
}
