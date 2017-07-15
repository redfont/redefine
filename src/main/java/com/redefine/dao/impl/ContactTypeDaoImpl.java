package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.ContactTypeDao;
import com.redefine.model.ContactType;

@Repository
public class ContactTypeDaoImpl implements ContactTypeDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	public ContactTypeDaoImpl() {
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addContactType(ContactType contactType) throws Exception {
		em.persist(contactType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactType> getContactTypes() throws Exception {
		Query query = em.createQuery("select c from ContactType c", ContactType.class);
		return query.getResultList();
	}

	@Override
	public ContactType getContactType(String code) throws Exception {
		return em.find(ContactType.class, code);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateContactType(ContactType contactType) throws Exception {
		em.merge(contactType);
	}

}
