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

@Entity
@Table(name="purchased_items")
public class PurchasedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="purchased_item_id")
	private Integer purchasedItemId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="total_cost")
	private Double totalCost;
	
	@ManyToOne
	@JoinColumn(name="item_id", referencedColumnName="item_id")
	private Item item;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Purchase purchase;
	
	public PurchasedItem(){}

	public Integer getPurchasedItemId() {
		return purchasedItemId;
	}

	public void setPurchasedItemId(Integer purchasedItemId) {
		this.purchasedItemId = purchasedItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
}
