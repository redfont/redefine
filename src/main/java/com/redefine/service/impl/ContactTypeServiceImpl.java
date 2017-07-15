package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.ContactTypeDao;
import com.redefine.model.ContactType;
import com.redefine.service.ContactTypeService;

@Service
public class ContactTypeServiceImpl implements ContactTypeService {
	
	@Autowired
	private ContactTypeDao contactTypeDao;
	
	public ContactTypeServiceImpl() {
	}
	
	@Override
	public void addContactType(ContactType contactType) throws Exception {
		contactTypeDao.addContactType(contactType);
	}

	@Override
	public List<ContactType> getContactTypes() throws Exception {
		return contactTypeDao.getContactTypes();
	}

	@Override
	public ContactType getContactType(String code) throws Exception {
		return contactTypeDao.getContactType(code);
	}

	@Override
	public void updateContactType(ContactType contactType) throws Exception {
		contactTypeDao.updateContactType(contactType);
	}

}
