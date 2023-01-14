package com.pfa.BackEnd.PFA.Projet.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Produit  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Float prixUnitaire;
	private int stock;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	private String image;
	
	//commande
	@ManyToMany(mappedBy = "produits")
	private List<Commande> commandes;
	
	//categories 
	@ManyToOne
	private Categorie categorie;
	
	
	//les paniers 
	@ManyToMany(mappedBy = "produits")
	 private List<Panier> paniers;


	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prixUnitaire=" + prixUnitaire + ", stock=" + stock
				+ ", description=" + description + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", commandes=" + commandes + ", categorie=" + categorie + ", paniers=" + paniers + "]";
	}
	

}
