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
public class Utilisateur {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nom;
	private String prenom;
	private String cin;
	private Date dateNaissance;
	private String adresse;
	private String numeroTelephone;
	private String rib;
	private String email;
	private String motDePasse;
	private Date createdAt;
	private Date updatedAt;
	private String role;
	
	
	public Utilisateur(Long id, String nom, String prenom, String cin, Date dateNaissance, String adresse,
			String numeroTelephone, String rib, String email, String motDePasse, Date createdAt, Date updatedAt,
			String role, List<Panier> paniers) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
		this.rib = rib;
		this.email = email;
		this.motDePasse = motDePasse;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.role = role;
		this.paniers = paniers;
	}


	//les paniers de l'utilisateur
	@OneToMany(mappedBy = "utilisateur")
	private List<Panier> paniers;
	
	
	//les paiement
	@OneToMany(mappedBy = "utilisateur")
	private List<Paiement> paiements;

	
	//commande
	@OneToMany(mappedBy = "utilisateur")
	private List<Commande> commandes;

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + ", numeroTelephone=" + numeroTelephone + ", rib=" + rib
				+ ", email=" + email + ", motDePasse=" + motDePasse + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", role=" + role + ", paniers=" + paniers + ", paiements=" + paiements + "]";
	}





	


}
