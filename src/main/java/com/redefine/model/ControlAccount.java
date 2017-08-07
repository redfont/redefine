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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name="control_accounts")
@Entity
public class ControlAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="control_account_id")
	private Integer controlAccountId;
	
	@Column(name="account_no")
	private String accountNumber;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date_created", insertable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name="date_updated", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@OneToMany(mappedBy="controlAccount", 
			orphanRemoval=true,
			cascade={CascadeType.ALL})
	@JsonManagedReference
	private List<ControlAccountSubsidiary> controlAccountSubsidiaries;
	
	public ControlAccount() {
		controlAccountSubsidiaries = new ArrayList<ControlAccountSubsidiary>();
	}

	/**
	 * @return the controlAccountId
	 */
	public Integer getControlAccountId() {
		return controlAccountId;
	}

	/**
	 * @param controlAccountId the controlAccountId to set
	 */
	public void setControlAccountId(Integer controlAccountId) {
		this.controlAccountId = controlAccountId;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/**
	 * @return the controlAccountSubsidiaries
	 */
	public List<ControlAccountSubsidiary> getControlAccountSubsidiaries() {
		return controlAccountSubsidiaries;
	}

	/**
	 * @param controlAccountSubsidiaries the controlAccountSubsidiaries to set
	 */
	public void setControlAccountSubsidiaries(
			List<ControlAccountSubsidiary> controlAccountSubsidiaries) {
		this.controlAccountSubsidiaries = controlAccountSubsidiaries;
	}

}
