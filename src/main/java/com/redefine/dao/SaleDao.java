package com.redefine.dao;

import java.util.List;

import com.redefine.model.Sale;

public interface SaleDao {

	public void addSale(Sale sale) throws Exception;
	public List<Sale> getSales() throws Exception;
	public Sale getSale(int id) throws Exception;
	public void update(Sale sale) throws Exception;
}
