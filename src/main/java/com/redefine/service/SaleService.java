package com.redefine.service;

import java.util.List;

import com.redefine.model.Sale;

public interface SaleService {

	public void addSale(Sale sale) throws Exception;
	public List<Sale> getSales() throws Exception;
	public Sale getSale(int id) throws Exception;
	public void update(Sale sale) throws Exception;
	
}
