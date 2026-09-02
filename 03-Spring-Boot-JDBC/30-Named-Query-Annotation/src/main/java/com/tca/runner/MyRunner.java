package com.tca.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.dto.StudentDTO;
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
	
	private void printStudentDTO(List<StudentDTO> students)
	{
		for(StudentDTO s : students)
		{
			
			System.out.println("Name       : " + s.getName());
			System.out.println("Percentage : " + s.getPer());
			System.out.println("Gender     : " + s.getGender());
			System.out.println("-".repeat(50));
		}
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*		
		List<Student> list = service.fetchByGender(Gender.MALE);
		if(list==null || list.isEmpty())
		{
			System.out.println("Data Not found");
		}
		else
		{
			printStudent(list);
		}
*/
		
		List<StudentDTO> list = service.fetchAllStudentDTO();
		if(list==null || list.isEmpty())
		{
			System.out.println("Data Not found");
		}
		else
		{
			printStudentDTO(list);
		}
		
	}

}
