package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.Date;

public class PaiementVo {
	private Long id;
	private String modePaiement ;
	private Date datePaiement;
	private Date createdAt;
	private Date updatedAt;
	
	public PaiementVo() {
		super();
	}
	public PaiementVo(Long id, String modePaiement, Date datePaiement, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.modePaiement = modePaiement;
		this.datePaiement = datePaiement;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
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
