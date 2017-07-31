package com.redefine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
