package com.tca.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Passport;
import com.tca.entity.Person;
import com.tca.service.PersonService;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired
	PersonService personService;

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*		
		Passport pass = new Passport();
		pass.setPassportNumber(1111111L);
		pass.setExpiryDate(LocalDate.of(2030, 1, 1));
		
		Person p = new Person();
		p.setName("Dia");
		p.setDateOfBirth(LocalDate.of(2001, 1, 1));
		p.setPassport(pass);
		
		p = personService.savePerson(p);
		
		System.out.println("Person save with id : "+p);
*/
/*		
		Person person = personService.fetchPersonById(1L);
		System.out.println("Person Id   : "+person.getPno());
		System.out.println("Person Name : "+person.getName());
		System.out.println("Person DOB  : "+person.getDateOfBirth());
		System.out.println("-".repeat(50));
		Passport pass = person.getPassport();
		System.out.println("Passport Number : "+pass.getPassportNumber());
		System.out.println("Passport Expiry : "+pass.getExpiryDate());
*/
		personService.removePerson(1L);
	}

}
