package com.redefine.service;

import java.util.List;

import com.redefine.model.ExpenseType;

public interface ExpenseTypeService {
	public void addExpenseType(ExpenseType expenseType) throws Exception;
	public List<ExpenseType> getExpenseTypes() throws Exception;
	public ExpenseType getExpenseType(String code) throws Exception;
	public void updateExpenseType(ExpenseType expenseType) throws Exception;
}
