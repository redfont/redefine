package com.redefine.dao;

import java.util.List;

import com.redefine.model.Person;

public interface PersonDao {

	public void add(Person person) throws Exception;
	public List<Person> getPersons(String contactType) throws Exception;
	public Person getPerson(int id) throws Exception;
	public void update(Person person) throws Exception;
}
