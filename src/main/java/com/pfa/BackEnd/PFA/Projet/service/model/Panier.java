package com.pfa.BackEnd.PFA.Projet.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantite;
	private float prixTotal;
	private Date date;
	private Date createdAt;
	private Date updatedAt;
	
	//contient plusieur produits
	@ManyToMany
	@JoinTable(name = "panier_produit",
	             joinColumns = @JoinColumn(name = "panier_id"),
	             inverseJoinColumns = @JoinColumn(name = "produit_id"))
	  private List<Produit> produits;
	
	
	 //appartient a un seul utilisateur
	 @ManyToOne
	 @JoinColumn(name=("utilisateur_id"))
	 private Utilisateur utilisateur;


	@Override
	public String toString() {
		return "Panier [id=" + id + ", quantite=" + quantite + ", prixTotal=" + prixTotal + ", dateCommande="
				+ date + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", produits=" + produits
				+ ", utilisateur=" + utilisateur + "]";
	}


	public Panier(Long id, int quantite, float prixTotal, Date dateCommande, Date createdAt, Date updatedAt,
			List<Produit> produits, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixTotal = prixTotal;
		this.date = dateCommande;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.produits = produits;
		this.utilisateur = utilisateur;
	}
	 	
	 



}
