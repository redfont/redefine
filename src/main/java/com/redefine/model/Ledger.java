package com.redefine.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="ledgers")
@Entity
public class Ledger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ledger_id")
	private Integer ledgerId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="desctiption")
	private String accountDescription;
	
	@OneToMany(mappedBy="ledger",
			cascade=CascadeType.ALL,
			orphanRemoval=true)
	private List<ControlAccount> controlAccounts;
	
	public Ledger() {
		
	}

	/**
	 * @return the ledgerId
	 */
	public Integer getLedgerId() {
		return ledgerId;
	}

	/**
	 * @param ledgerId the ledgerId to set
	 */
	public void setLedgerId(Integer ledgerId) {
		this.ledgerId = ledgerId;
	}
	
	/**
	 * @return the accountTitle
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param accountTitle the accountTitle to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the accountDescription
	 */
	public String getAccountDescription() {
		return accountDescription;
	}

	/**
	 * @param accountDescription the accountDescription to set
	 */
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	/**
	 * @return the controlAccounts
	 */
	public List<ControlAccount> getControlAccounts() {
		return controlAccounts;
	}

	/**
	 * @param controlAccounts the controlAccounts to set
	 */
	public void setControlAccounts(List<ControlAccount> controlAccounts) {
		this.controlAccounts = controlAccounts;
	}

}
