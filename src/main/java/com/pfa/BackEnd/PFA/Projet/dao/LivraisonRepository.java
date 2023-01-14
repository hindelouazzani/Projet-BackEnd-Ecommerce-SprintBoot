package com.pfa.BackEnd.PFA.Projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

	
}
