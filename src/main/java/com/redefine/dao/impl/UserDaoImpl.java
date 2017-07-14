package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.UserDao;
import com.redefine.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	public UserDaoImpl() {
		
	}

	@Transactional(readOnly=false)
	@Override
	public void addUser(User user) throws Exception {
		em.persist(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() throws Exception {
		Query query = em.createQuery("select u from User u", User.class);
		return query.getResultList();
	}

	@Override
	public User getUser(int id) throws Exception {
		return em.find(User.class, id);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateUser(User user) throws Exception {
		em.merge(user);
	}

}
