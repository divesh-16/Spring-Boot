package com.tca.runner;

import java.time.LocalDate;
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
	
	private void printStudentObject(List<Object[]> students)
	{
		for(Object[] s : students)
		{
			System.out.println("Roll Number: " + s[0]);
			System.out.println("Name       : " + s[1]);
			System.out.println("Percentage : " + s[2]);
			System.out.println("Gender     : " + s[3]);
			System.out.println("Birth Date : " + s[4]);
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
//		Student s = new Student();
//		s.setName("AAA");
//		s.setGender(Gender.FEMALE);
//		s.setBirthDate(LocalDate.now());
//		s.setPer(66.23);
//		
//		Student saveStudent = service.saveStudent(s);
//		
//		System.out.println("Student saved with : "+saveStudent);
		
		Student s1 = new Student();
		s1.setName("BBB");
		s1.setGender(Gender.FEMALE);
		s1.setBirthDate(LocalDate.now());
		s1.setPer(86.23);
		
		Student s2 = new Student();
		s2.setName("CCC");
		s2.setGender(Gender.MALE);
		s2.setBirthDate(LocalDate.now());
		s2.setPer(67.23);
		
		Student s3 = new Student();
		s3.setName("DDD");
		s3.setGender(Gender.MALE);
		s3.setBirthDate(LocalDate.now());
		s3.setPer(76.23);
		
		
		List<Student> students = service.saveStudents(List.of(s1,s2,s3));
		printStudent(students);
	}
}
