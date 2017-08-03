package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.redefine.dao.SaleDao;
import com.redefine.model.Sale;

@Repository
public class SaleDaoImpl implements SaleDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	public SaleDaoImpl() {
		
	}

	@Override
	public void addSale(Sale sale) throws Exception {
		em.persist(sale);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSales() throws Exception {
		Query query = em.createQuery("select s from Sale s");
		return query.getResultList();
	}

	@Override
	public Sale getSale(int id) throws Exception {
		Sale sale = em.find(Sale.class, id);
		return sale;
	}

	@Override
	public void update(Sale sale) throws Exception {
		em.merge(sale);
	}

}
