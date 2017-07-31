package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.redefine.dao.PurchaseDao;
import com.redefine.model.Purchase;
import com.redefine.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;
	
	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		purchaseDao.addPurchase(purchase);
	}

	@Override
	public List<Purchase> getPurchases() throws Exception {
		return purchaseDao.getPurchases();
	}

	@Override
	public Purchase getPurchase(int id) throws Exception {
		return purchaseDao.getPurchase(id);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		purchaseDao.updatePurchase(purchase);
	}

}
