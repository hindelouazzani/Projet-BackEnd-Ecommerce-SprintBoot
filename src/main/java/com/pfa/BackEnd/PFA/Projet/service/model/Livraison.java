package com.pfa.BackEnd.PFA.Projet.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Livraison {
	
	public Livraison(Long id, Date dateLivraison, Date createdAt, Date updatedAt, List<Commande> commandes) {
		super();
		this.id = id;
		this.dateLivraison = dateLivraison;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commandes = commandes;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateLivraison;
	private Date createdAt;
	private Date updatedAt;
	
	

	
	//une livarison conttient plusieur panier
	@OneToMany(mappedBy = "livraison")
	private List<Commande> commandes;




	@Override
	public String toString() {
		return "Livraison [id=" + id + ", dateLivraison=" + dateLivraison + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", commandes=" + commandes + "]";
	}
	
	



}
