package com.redefine.dao;

import java.util.List;

import com.redefine.model.ContactType;

public interface ContactTypeDao {

	public void addContactType(ContactType contactType) throws Exception;
	public List<ContactType> getContactTypes() throws Exception;
	public ContactType getContactType(String code) throws Exception;
	public void updateContactType(ContactType contactType) throws Exception;
}
