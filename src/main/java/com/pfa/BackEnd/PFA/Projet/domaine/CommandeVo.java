package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.Date;

public class CommandeVo {
	
	private Long id; 
	private float sommeTotal;
	private int quantite;
	private Date dateCommande;
	private Date createdAt;
	private Date updatedAt;
	
	public CommandeVo(Long id, float sommeTotal, int quantite, Date dateCommande, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.sommeTotal = sommeTotal;
		this.quantite = quantite;
		this.dateCommande = dateCommande;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public CommandeVo() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getSommeTotal() {
		return sommeTotal;
	}

	public void setSommeTotal(float sommeTotal) {
		this.sommeTotal = sommeTotal;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
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


