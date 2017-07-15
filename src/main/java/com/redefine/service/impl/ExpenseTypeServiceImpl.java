package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.ExpenseTypeDao;
import com.redefine.model.ExpenseType;
import com.redefine.service.ExpenseTypeService;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {

	@Autowired
	private ExpenseTypeDao expenseTypeDao;
	
	public ExpenseTypeServiceImpl() {
		
	}
	
	@Override
	public void addExpenseType(ExpenseType expenseType) throws Exception {
		expenseTypeDao.addExpenseType(expenseType);
	}

	@Override
	public List<ExpenseType> getExpenseTypes() throws Exception {
		return expenseTypeDao.getExpenseTypes();
	}

	@Override
	public ExpenseType getExpenseType(String code) throws Exception {
		return expenseTypeDao.getExpenseType(code);
	}

	@Override
	public void updateExpenseType(ExpenseType expenseType) throws Exception {
		expenseTypeDao.updateExpenseType(expenseType);
	}

}
