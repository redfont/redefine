package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.CategoryDao;
import com.redefine.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	public CategoryDaoImpl() {
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addCategory(Category category) throws Exception {
		em.persist(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() throws Exception {
		Query query = em.createQuery("select c from Category c", Category.class);
		return query.getResultList();
	}

	@Override
	public Category getCategory(String code) throws Exception {
		return em.find(Category.class, code);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateCategory(Category category) throws Exception {
		em.merge(category);
	}

}
