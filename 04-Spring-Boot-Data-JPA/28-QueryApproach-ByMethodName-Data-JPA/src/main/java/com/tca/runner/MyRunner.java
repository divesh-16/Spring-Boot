package com.tca.runner;

import java.time.LocalDate;
import java.util.ArrayList;
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
		// show by gender
		/*
		List<Student> list = service.fetchByGender(Gender.MALE);
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		// show by birth date
		/*
		List<Student> list = service.fetchByBirthDate(LocalDate.of(2026, 8, 24));
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		// show by birth date greater than 
		/*
		List<Student> list = service.fetchByBirthDateGreaterThan(LocalDate.of(2019, 7, 29));
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		// by per in range
		/*
		List<Student> list = service.fetchByPerBetween(36.0, 70.0);
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		/*
		// by date in range
		List<Student> list = service.fetchByBirthDateBetween(LocalDate.of(2025, 1, 1), LocalDate.now());
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		/*
		// by date in after
		List<Student> list = service.fetchByBirthDateAfter(LocalDate.of(2021, 1, 1));
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		/*
		// by date in after
		List<Student> list = service.fetchByBirthDateBefore(LocalDate.of(2022, 1, 1));
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		//name starting with ignoring case
		/*
		List<Student> list = service.fetchByNameStartingWithIgnoreCase("a");
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		// by gender order by per
		/*
		List<Student> list = service.fetchByGenderOrderByPerDesc(Gender.FEMALE);
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		// by gender and per >= 
		/*
		List<Student> list = service.fetchByGenderAndPerGreaterThanEqual(Gender.MALE,60.33);
		if(list == null || list.isEmpty())
		{
			System.out.println("No student found with ");
		}
		else
		{
			printStudent(list);
		}
		*/
		
		//get count by gender
		/*
		System.out.println(service.getCountByGender(Gender.FEMALE));
		*/
		
		// exists by rno
		System.out.println(service.existsByRno(105));
		System.out.println(service.existsByRno(111));
	}

}
