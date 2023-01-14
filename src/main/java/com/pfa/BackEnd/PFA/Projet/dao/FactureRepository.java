package com.pfa.BackEnd.PFA.Projet.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	List<Facture> findByDateFacture(Date d);
	List<Facture> findByTotalFacture(Facture f);
	List<Facture> findByCreatedAt(Date d);
	List<Facture> findByUpdatedAt(Date d );
	

}
