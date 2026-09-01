package com.tca.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entities.Gender;
import com.tca.entities.Student;
import com.tca.service.StudentService;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired
	StudentService service;
	
	private void printStudent(List<Student> students)
	{
		for(Student s : students)
		{
			System.out.println("Roll Number: " + s.getRno());
			System.out.println("Name       : " + s.getName());
			System.out.println("Percentage : " + s.getPer());
			System.out.println("Gender     : " + s.getGender());
			System.out.println("Birth Date : " + s.getBirthDate());
			System.out.println("-".repeat(50));
		}
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		/*
		// find all students 
		List<Student> list = service.fetchAllStudent();
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		// find by per range
		/*
		List<Student> list = service.fetchPercentageRangeOfStudent(55.0, 80.0 );
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		List<Object[]> list = service.fetchGenderNamePer(30.0, Gender.FEMALE);
		for(Object[] s: list)
		{
			System.out.println("Name       : " + s[0]);
			System.out.println("Percentage : " + s[1]);
			System.out.println("Gender     : " + s[2]);
			System.out.println("-".repeat(50));
		}
	}
}
