package com.redefine.service;

import java.util.List;

import com.redefine.model.Person;

public interface ProspectService {

	public void addProspect(Person person) throws Exception;
	public List<Person> getProspects() throws Exception;
	public Person getProspect(int id) throws Exception;
	public void updateProspect(Person person) throws Exception;
}
