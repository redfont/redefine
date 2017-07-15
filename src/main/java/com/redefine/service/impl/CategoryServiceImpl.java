package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.CategoryDao;
import com.redefine.model.Category;
import com.redefine.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public CategoryServiceImpl() {
		
	}
	
	@Override
	public void addCategory(Category category) throws Exception {
		categoryDao.addCategory(category);
	}

	@Override
	public List<Category> getCategories() throws Exception {
		return categoryDao.getCategories();
	}

	@Override
	public Category getCategory(String code) throws Exception {
		return categoryDao.getCategory(code);
	}

	@Override
	public void updateCategory(Category category) throws Exception {
		categoryDao.updateCategory(category);
	}

}
