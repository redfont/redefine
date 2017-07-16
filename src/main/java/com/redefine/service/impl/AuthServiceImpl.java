package com.redefine.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.redefine.dao.UserDao;
import com.redefine.model.User;
import com.redefine.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean auth(String username, String password) throws Exception {
		
		User user = userDao.getUserByUsername(username);
		
		if(user != null) {	
			boolean passwordMatch = passwordEncoder.matches(password, user.getPassword());
			if(passwordMatch) {
				httpSession.setAttribute("user", user);
				return true;
			}
		}
		return false;
	}

	@Override
	public void invalidateSession() throws Exception {
		httpSession.removeAttribute("user");
		httpSession.invalidate();
	}
}
