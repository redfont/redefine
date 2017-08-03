package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.SaleDao;
import com.redefine.model.Sale;
import com.redefine.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleDao saleDao;
	
	public SaleServiceImpl() {}

	@Override
	public void addSale(Sale sale) throws Exception {
		saleDao.addSale(sale);
	}

	@Override
	public List<Sale> getSales() throws Exception {
		return saleDao.getSales();
	}

	@Override
	public Sale getSale(int id) throws Exception {
		return saleDao.getSale(id);
	}

	@Override
	public void update(Sale sale) throws Exception {
		saleDao.update(sale);
	}

}
