package com.pfa.BackEnd.PFA.Projet.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Panier;

public interface PanierRepository extends JpaRepository<Panier,Long> {

	
	List<Panier> findByQuantite(int q);
	List<Panier> findByPrixTotal(float prixtotal);
	List<Panier> findByDate(Date d);
	List<Panier> findByCreatedAt(Date d);
	List<Panier> findByUpdatedAt(Date d );
	
}
