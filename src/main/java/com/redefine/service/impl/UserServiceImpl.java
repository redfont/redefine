package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.redefine.dao.UserDao;
import com.redefine.model.User;
import com.redefine.service.UserService;
import com.redefine.util.Util;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl() {
	}

	@Override
	public void addUser(User user) throws Exception {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public User getUser(int id) throws Exception {
		return userDao.getUser(id);
	}

	@Override
	public void updateUser(User user) throws Exception {
		User managed = null;
		if(Util.hasValue(user.getPassword())){
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			managed = user;
		} else {
			managed = userDao.getUser(user.getUserId());
			managed.setEmail(user.getEmail());
		}
		userDao.updateUser(managed);
	}	
}
