package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Person;
import com.tca.repository.PersonRepository;

@Service("personService")
public class PersonServiceImpl implements PersonService 
{
	@Autowired
	PersonRepository repo;

	@Override
	public Person savePerson(Person person) 
	{
		return repo.save(person);
	}

	@Override
	public Person fetchPersonById(Long id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public void removePerson(Long id) 
	{
		repo.deleteById(id);		
	}

}
