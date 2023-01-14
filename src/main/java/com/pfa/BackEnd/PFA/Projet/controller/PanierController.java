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

import com.pfa.BackEnd.PFA.Projet.domaine.PanierVo;
import com.pfa.BackEnd.PFA.Projet.service.IServicePanier;
@RestController
public class PanierController {

	@Autowired
	private IServicePanier service; 
	
	/**
	 * pour chercher tous les paniers 
	 * */
	@GetMapping(value = "/panier", produces = {MediaType.APPLICATION_JSON_VALUE }) 
	public List<PanierVo> getAll() { 
			 return service.getPaniers(); 
	} 
	
	/**
	 * pour chercher un panier par son id 
	 * */
	@GetMapping(value = "/panier/{id}") 
	public ResponseEntity<Object> getPanierById(@PathVariable(value = "id") Long panierVoId) 
	{ 
		PanierVo empVoFound = service.getPanierById(panierVoId); 
		if (empVoFound == null) 
		 	return new ResponseEntity<>("panier doen't exist", HttpStatus.OK); 
		return new ResponseEntity<>(empVoFound, HttpStatus.OK); 
	 } 
	
	/**
	 * pour creer un nouveau panier 
	 * */
	@PostMapping(value = "/panier") 
	public ResponseEntity<Object> createPanier(@Valid @RequestBody PanierVo panierVo) { 
		service.save(panierVo); 
		return new ResponseEntity<>("panier is created successfully", 
			 HttpStatus.CREATED); 
	} 
	
	/**
	 * Pour modifier une panier par son id
	 */
	@PutMapping(value = "/panier/{id}") 
	public ResponseEntity<Object> updatePanier(@PathVariable(name = "id") Long panierVoId, 
	@RequestBody PanierVo panierVo) { 
		PanierVo empVoFound = service.getPanierById(panierVoId); 
		if (empVoFound == null) 
			return new ResponseEntity<>("employee doen't exist", HttpStatus.OK); 
			panierVo.setId(panierVoId); 
		service.save(panierVo); 
		return new ResponseEntity<>("Employee is updated successsfully", 
	HttpStatus.OK); 
	 }

	/**
	 * Pour supprimer  panier par son id
	 */
	@DeleteMapping(value = "/panier/{id}") 
	public ResponseEntity<Object> deletePanier(@PathVariable(name = "id") Long panierVoId) { 
		PanierVo empVoFound = service.getPanierById(panierVoId); 
		if (empVoFound == null) 
			return new ResponseEntity<>("employee doen't exist", HttpStatus.OK); 
		service.delete(panierVoId); 
		return new ResponseEntity<>("Employee is deleted successsfully", 
	HttpStatus.OK); 
	 } 
	
	/**
	 * Pour chercher tous les panniers
	 */
	@GetMapping(value = "/sortpanier/{fieldName}", produces = { 
	MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public List<PanierVo> sortBy(@PathVariable String fieldName) { 
		return service.sortBy(fieldName); 
	}
	
	/**
	 * Afficher la liste des paniers en utilisant la pagination
	 */
	@GetMapping("/paginationpanier/{pageid}/{size}") 
	public List<PanierVo> pagination(@PathVariable int pageid, @PathVariable int size, 
	Model m) { 
	 return service.findAll(pageid, size); 
	 } 

	
	

}
