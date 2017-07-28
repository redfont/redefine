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

@Table(name="ledger_subsidiaries")
@Entity
public class LedgerSubsidiary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ledger_subsidiary_id")
	private Integer ledgerSubsidiaryId;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="control_account_id")
	private ControlAccount controlAccount;

	public LedgerSubsidiary() {
	}

	public Integer getLedgerSubsidiaryId() {
		return ledgerSubsidiaryId;
	}

	public void setLedgerSubsidiaryId(Integer ledgerSubsidiaryId) {
		this.ledgerSubsidiaryId = ledgerSubsidiaryId;
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
