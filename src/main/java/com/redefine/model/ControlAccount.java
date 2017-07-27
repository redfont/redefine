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
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ledger_id")
	private Ledger ledger;
	
	public ControlAccount() {
		
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
	 * @return the ledger
	 */
	public Ledger getLedger() {
		return ledger;
	}

	/**
	 * @param ledger the ledger to set
	 */
	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}

}
