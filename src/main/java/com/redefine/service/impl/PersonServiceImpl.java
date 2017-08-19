package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.PersonDao;
import com.redefine.model.Person;
import com.redefine.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao prospectDao;
	
	@Override
	public void addProspect(Person person) throws Exception {
		prospectDao.add(person);
	}

	@Override
	public List<Person> getPersons(String contactType) throws Exception {
		return prospectDao.getPersons(contactType);
	}

	@Override
	public Person getProspect(int id) throws Exception {
		return prospectDao.getPerson(id);
	}

	@Override
	public void updateProspect(Person person) throws Exception {
		prospectDao.update(person);
	}

}
