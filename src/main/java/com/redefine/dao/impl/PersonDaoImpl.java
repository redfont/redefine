package com.redefine.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redefine.dao.PersonDao;
import com.redefine.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext(unitName="rdfine")
	private EntityManager em;
	
	@Transactional(readOnly=false)
	@Override
	public void add(Person person) throws Exception {
		em.persist(person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersons() throws Exception {
		Query query = em.createQuery("select p from Person p where p.isProspect = :PROSPECT", Person.class);
		query.setParameter("PROSPECT", Boolean.TRUE);
		return query.getResultList();
	}

	@Override
	public Person getPerson(int id) throws Exception {
		return em.find(Person.class, id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Person person) throws Exception {
		em.merge(person);
	}

}
