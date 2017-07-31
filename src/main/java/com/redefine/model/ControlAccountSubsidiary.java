package com.redefine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name="ctrl_acct_subsidiaries")
@Entity
public class ControlAccountSubsidiary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ctrl_acct_subsidiary_id")
	private Integer controlAccountSubsidiaryId;
		
	@Column(name="account_no")
	private String accountNumber;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="control_account_id")
	@JsonBackReference
	private ControlAccount controlAccount;
	
	public ControlAccountSubsidiary() {
	}

	/**
	 * @return the controlAccountSubsidiaryId
	 */
	public Integer getControlAccountSubsidiaryId() {
		return controlAccountSubsidiaryId;
	}

	/**
	 * @param controlAccountSubsidiaryId the controlAccountSubsidiaryId to set
	 */
	public void setControlAccountSubsidiaryId(Integer controlAccountSubsidiaryId) {
		this.controlAccountSubsidiaryId = controlAccountSubsidiaryId;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ControlAccount getControlAccount() {
		return controlAccount;
	}

	public void setControlAccount(ControlAccount controlAccount) {
		this.controlAccount = controlAccount;
	}
}
