package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.ControlAccountDao;
import com.redefine.model.ControlAccount;
import com.redefine.service.ControlAccountService;

@Service
public class ControlAccountServiceImpl implements ControlAccountService {

	@Autowired
	private ControlAccountDao accountChartDao;
	
	public ControlAccountServiceImpl() {
	}

	@Override
	public void addControlAccount(ControlAccount controlAccount)
			throws Exception {
		accountChartDao.addControlAccount(controlAccount);
	}

	@Override
	public List<ControlAccount> getControlAccounts() throws Exception {
		return accountChartDao.getControlAccounts();
	}

	@Override
	public ControlAccount getControlAccount(Integer id) throws Exception {
		return accountChartDao.getControlAccount(id);
	}

	@Override
	public void updateControlAccount(ControlAccount controlAccount)
			throws Exception {
		accountChartDao.updateControlAccount(controlAccount);
	}

}
