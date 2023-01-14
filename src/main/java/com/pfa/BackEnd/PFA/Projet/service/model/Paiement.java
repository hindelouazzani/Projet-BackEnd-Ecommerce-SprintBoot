package com.pfa.BackEnd.PFA.Projet.service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Paiement {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modePaiement ;
	private Date datePaiement;
	private Date createdAt;
	private Date updatedAt;
	
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;


	
	public Paiement(Long id, String modePaiement, Date datePaiement, Date createdAt, Date updatedAt,
			Utilisateur utilisateur) {
		super();
		this.id = id;
		this.modePaiement = modePaiement;
		this.datePaiement = datePaiement;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", modePaiement=" + modePaiement + ", datePaiement=" + datePaiement
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", utilisateur=" + utilisateur + "]";
	}
	
	
	
	



}
