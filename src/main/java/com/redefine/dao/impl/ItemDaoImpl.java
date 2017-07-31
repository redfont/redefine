package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.ItemDao;
import com.redefine.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=false)
	public void add(Item item) throws Exception {
		em.persist(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getList() throws Exception {
		Query query = em.createQuery("select i from Item i where i.isActive = :ACTIVE");
		query.setParameter("ACTIVE", Boolean.TRUE);
		return query.getResultList();
	}

	@Override
	public Item getItem(int id) throws Exception {
		return em.find(Item.class, id);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Item item) throws Exception {
		em.merge(item);
	}

}
