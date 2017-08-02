package com.redefine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class SoldItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sold_item_id")
	private Integer soldItemId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="unit_srp")
	private Double unitSrp;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@OneToMany
	@JoinColumn(name="purchase_item_id", referencedColumnName="purchased_item_id")
	private PurchasedItem purchaseItem;
	
	public SoldItem(){}

	public Integer getSoldItemId() {
		return soldItemId;
	}

	public void setSoldItemId(Integer soldItemId) {
		this.soldItemId = soldItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitSrp() {
		return unitSrp;
	}

	public void setUnitSrp(Double unitSrp) {
		this.unitSrp = unitSrp;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PurchasedItem getPurchaseItem() {
		return purchaseItem;
	}

	public void setPurchaseItem(PurchasedItem purchaseItem) {
		this.purchaseItem = purchaseItem;
	}
	
}
