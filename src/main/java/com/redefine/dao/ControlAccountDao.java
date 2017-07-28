package com.redefine.dao;

import java.util.List;

import com.redefine.model.ControlAccount;

public interface ControlAccountDao {
	public void addControlAccount(ControlAccount controlAccount) throws Exception;
	public List<ControlAccount> getControlAccounts() throws Exception;
	public ControlAccount getControlAccount(Integer id) throws Exception;
	public void updateControlAccount(ControlAccount controlAccount) throws Exception;
}
