package com.pfa.BackEnd.PFA.Projet.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Commande;

public interface CommandeRepository  extends JpaRepository<Commande, Long> {
		
	List<Commande> findBySommeTotal(float s);
	List<Commande> findByQuantite(int q);
	List<Commande> findByDateCommande(Date d);
	List<Commande> findByCreatedAt(Date d);
	List<Commande> findByUpdatedAt(Date d);
	
}
