package com.pfa.BackEnd.PFA.Projet.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private float sommeTotal;
	private int quantite;
	private Date dateCommande;
	private Date createdAt;
	private Date updatedAt;
	
	
	//facture
	@OneToOne
	@JoinColumn(name="facture_id")
	private Facture facture;
	
	//livraison
	@ManyToOne
	@JoinColumn(name="livraison_id")
	private Livraison livraison;
	
	//utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;
	
	//produit
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "commande_produit",
	             joinColumns = @JoinColumn(name = "commande_id"),
	             inverseJoinColumns = @JoinColumn(name = "produit_id"))
	  private List<Produit> produits;

	@Override
	public String toString() {
		return "Commande [id=" + id + ", sommeTotal=" + sommeTotal + ", quantite=" + quantite + ", dateCommande="
				+ dateCommande + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", facture=" + facture
				+ ", livraison=" + livraison + ", utilisateur=" + utilisateur + ", produits=" + produits + "]";
	}

	public Commande(Long id, float sommeTotal, int quantite, Date dateCommande, Date createdAt, Date updatedAt,
			Facture facture, Livraison livraison, Utilisateur utilisateur, List<Produit> produits) {
		super();
		this.id = id;
		this.sommeTotal = sommeTotal;
		this.quantite = quantite;
		this.dateCommande = dateCommande;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.facture = facture;
		this.livraison = livraison;
		this.utilisateur = utilisateur;
		this.produits = produits;
	}
	

}
