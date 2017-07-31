package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.PurchaseDao;
import com.redefine.model.Purchase;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	@Transactional(readOnly=false)
	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		em.persist(purchase);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getPurchases() throws Exception {
		Query query = em.createQuery("select p from Purchase p");
		return query.getResultList();
	}

	@Override
	public Purchase getPurchase(int id) throws Exception {
		return em.find(Purchase.class, id);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		em.merge(purchase);
	}

}
