package com.redefine.service;

public interface AuthService {
	public boolean auth(String username, String password) throws Exception;
	public void invalidateSession() throws Exception;
}
