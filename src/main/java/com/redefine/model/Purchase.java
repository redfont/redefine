package com.redefine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="purchases")
public class Purchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="purchase_id")
	private Integer purchaseId;
	
	@Column(name="purchase_date")
	private Date purchaseDate;
	
	@Column(name="date_created",insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name="date_updated",insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_by")
	private String updatedBy;

	@OneToMany(mappedBy="purchase",
			cascade=CascadeType.ALL,
			orphanRemoval=true)
	@JsonManagedReference
	private List<PurchasedItem> purchaseItems;
	
	@ManyToOne
	@JoinColumn(name="person_id", referencedColumnName="person_id")
	private Person supplier;
	
	public Purchase(){
		purchaseItems = new ArrayList<PurchasedItem>();
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<PurchasedItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(List<PurchasedItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

	/**
	 * @return the supplier
	 */
	public Person getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Person supplier) {
		this.supplier = supplier;
	}

}
