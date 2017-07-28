package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.ControlAccountDao;
import com.redefine.model.ControlAccount;

@Repository
public class ControlAccountDaoImpl implements ControlAccountDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	
	public ControlAccountDaoImpl() {
		
	}

	@Transactional(readOnly=false)
	@Override
	public void addControlAccount(ControlAccount controlAccount)
			throws Exception {
		em.persist(controlAccount);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ControlAccount> getControlAccounts() throws Exception {
		Query query = em.createQuery("select ca from ControlAccount ca");
		return query.getResultList();
	}

	@Override
	public ControlAccount getControlAccount(Integer id) throws Exception {
		ControlAccount ctrlAcct = em.find(ControlAccount.class, id);
		return ctrlAcct;
	}

	@Transactional(readOnly=false)
	@Override
	public void updateControlAccount(ControlAccount controlAccount)
			throws Exception {
		em.merge(controlAccount);
	}

}
