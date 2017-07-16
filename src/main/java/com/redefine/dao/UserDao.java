package com.redefine.dao;

import java.util.List;

import com.redefine.model.User;

public interface UserDao {

	public void addUser(User user) throws Exception;
	public List<User> getUsers() throws Exception;
	public User getUser(int id) throws Exception;
	public void updateUser(User user) throws Exception;
	public User getUserByUsername(String username) throws Exception;
}
