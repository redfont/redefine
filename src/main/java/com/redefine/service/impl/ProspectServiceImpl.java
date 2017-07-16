package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.ProspectDao;
import com.redefine.model.Person;
import com.redefine.service.ProspectService;

@Service
public class ProspectServiceImpl implements ProspectService {

	@Autowired
	private ProspectDao prospectDao;
	
	@Override
	public void addProspect(Person person) throws Exception {
		prospectDao.add(person);
	}

	@Override
	public List<Person> getProspects() throws Exception {
		return prospectDao.getPersons();
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
