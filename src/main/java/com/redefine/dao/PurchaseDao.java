package com.redefine.dao;

import java.util.List;

import com.redefine.model.Purchase;

public interface PurchaseDao {
	public void addPurchase(Purchase purchase) throws Exception;
	public List<Purchase> getPurchases() throws Exception;
	public Purchase getPurchase(int id) throws Exception;
	public void updatePurchase(Purchase purchase) throws Exception;
}
