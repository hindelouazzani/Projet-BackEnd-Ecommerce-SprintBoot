package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.Date;

public class PanierVo {

	private Long id;
	private int quantite;
	private float prixTotal;
	private Date date;
	private Date createdAt;
	private Date updatedAt;
	
	public PanierVo() {
			super();
	}

	public PanierVo(Long id, int quantite, float prixTotal, Date dateCommande, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixTotal = prixTotal;
		this.date = dateCommande;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date dateCommande) {
		this.date = dateCommande;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

}
