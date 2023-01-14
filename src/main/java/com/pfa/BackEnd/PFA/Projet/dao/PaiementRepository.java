package com.pfa.BackEnd.PFA.Projet.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfa.BackEnd.PFA.Projet.service.model.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {

	List<Paiement> findByModePaiement(String modePaiement);
	List<Paiement> findByDatePaiement(Date datePaiement);
	List<Paiement> findByCreatedAt(Date d);
	List<Paiement> findByUpdatedAt(Date d );
	
}
