package com.pfa.BackEnd.PFA.Projet.domaine;

import java.util.Date;

public class FactureVo {
	

	private Long id;
	private Date dateFacture;
	private float totalFacture;
	private Date createdAt;
	private Date updatedAt;

	public FactureVo() {
		super();
	}
	
	
	public FactureVo(Long id, Date dateFacture, float totalFacture, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
		this.totalFacture = totalFacture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateFacture() {
		return dateFacture;
	}


	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}


	public float getTotalFacture() {
		return totalFacture;
	}


	public void setTotalFacture(float totalFacture) {
		this.totalFacture = totalFacture;
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
