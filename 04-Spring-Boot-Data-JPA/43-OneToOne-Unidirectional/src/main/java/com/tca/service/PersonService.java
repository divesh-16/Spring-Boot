package com.tca.service;

import com.tca.entity.Person;

public interface PersonService 
{
	public Person savePerson(Person person);
	public Person fetchPersonById(Long id);
	public void removePerson(Long id);
}
