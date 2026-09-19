package com.tca.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Passport;
import com.tca.entity.Person;
import com.tca.service.PassportService;
import com.tca.service.PersonService;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired
	PersonService personService;
	
	@Autowired
	PassportService passportService;

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*		
		// Save Parent first and then passport
		Person p = new Person();
		p.setName("Dia");
		p.setDateOfBirth(LocalDate.of(2001, 1, 1));
		p = personService.savePerson(p);
		
		Passport pass = new Passport();
		pass.setPassportNumber(1111111L);
		pass.setExpiryDate(LocalDate.of(2030, 1, 1));
		pass.setPerson(p);
				
		// setting both in bi-directional is a compulsion
		p.setPassport(pass);
		pass.setPerson(p);
		
		pass = passportService.savePassport(pass);
		
	
		
		//System.out.println("Passport save with person Id : "+pass.getPerson().getPno());
*/
/*		
		Passport pass = passportService.fetchById(1111111L);
		System.out.println("Passport Number : "+pass.getPassportNumber());
		System.out.println("Passport Expiry : "+pass.getExpiryDate());
		System.out.println("-".repeat(50));
		Person person = pass.getPerson();
		System.out.println("Person Id   : "+person.getPno());
		System.out.println("Person Name : "+person.getName());
		System.out.println("Person DOB  : "+person.getDateOfBirth());
*/		
		

	
		passportService.removeById(1111111L);
	}

}
