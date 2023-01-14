 package com.pfa.BackEnd.PFA.Projet.service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateFacture;
	private float totalFacture;
	private Date createdAt;
	private Date updatedAt;
	
	
	//le commande de la facture	
	@OneToOne(mappedBy = "facture")
	private Commande commande;
	
	public Facture(Long id, Date dateFacture, float totalFacture, Date createdAt, Date updatedAt, Commande commande) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
		this.totalFacture = totalFacture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commande = commande;
	}


	@Override
	public String toString() {
		return "Facture [id=" + id + ", dateFacture=" + dateFacture + ", totalFacture=" + totalFacture + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", commande=" + commande + "]";
	}


}
