package com.tca.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Student;
import com.tca.service.StudentService;

@Component
public class MyRunner implements ApplicationRunner 
{
	@Autowired
	StudentService service;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*		
		Student s = new Student();
		s.setName("AAA");
		s.setPer(66.0);
		
		s = service.saveStudent(s);
		System.out.println("Student saved "+s);
*/
		Student s = service.fetchById(1);
		System.out.println("Student saved "+s);
		
	}

}
