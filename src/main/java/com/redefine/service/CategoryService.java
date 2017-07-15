package com.redefine.service;

import java.util.List;

import com.redefine.model.Category;

public interface CategoryService {

	public void addCategory(Category category) throws Exception;
	public List<Category> getCategories() throws Exception;
	public Category getCategory(String code) throws Exception;
	public void updateCategory(Category category) throws Exception;
	
}
