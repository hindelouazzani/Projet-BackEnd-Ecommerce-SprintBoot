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
public class Categorie {
	
	
	public Categorie(Long id, String nom, Date createdAt, Date updatedAt, List<Produit> produits) {
		super();
		this.id = id;
		this.nom = nom;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.produits = produits;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Date createdAt;
	private Date updatedAt;
	
	
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;


	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", produits=" + produits + "]";
	}

}
