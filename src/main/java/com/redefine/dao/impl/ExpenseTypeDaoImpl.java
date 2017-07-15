package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.ExpenseTypeDao;
import com.redefine.model.ExpenseType;

@Repository
public class ExpenseTypeDaoImpl implements ExpenseTypeDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	public ExpenseTypeDaoImpl() {
	
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addExpenseType(ExpenseType expenseType) throws Exception {
		em.persist(expenseType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpenseType> getExpenseTypes() throws Exception {
		Query query = em.createQuery("select e from ExpenseType e", ExpenseType.class);
		return query.getResultList();
	}

	@Override
	public ExpenseType getExpenseType(String code) throws Exception { 
		return em.find(ExpenseType.class, code);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateExpenseType(ExpenseType expenseType) throws Exception {
		em.merge(expenseType);
	}

}
