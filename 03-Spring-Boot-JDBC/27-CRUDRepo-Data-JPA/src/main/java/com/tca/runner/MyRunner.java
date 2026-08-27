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
		//save()
		/*
		
		Student student1 = new Student(101,"AAA", 60.0, Gender.FEMALE, LocalDate.now());
		Student student2 = new Student(102,"BBB", 80.0, Gender.FEMALE, LocalDate.of(2021,8,15));
		Student student3 = new Student(103,"CCC", 70.0, Gender.MALE, LocalDate.of(2019,7,29));
		Student s1 = new Student(104,"DDD", 35.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		Student s2 = new Student(105,"EEE", 55.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		Student s3 = new Student(106,"FFF", 23.0, Gender.FEMALE, LocalDate.now());
		service.saveStudent(student1);
		service.saveStudent(student2);
		service.saveStudent(student3);
		service.saveStudent(s1);
		service.saveStudent(s2);
		service.saveStudent(s3);
		System.out.println("Student Saved");
		
		
		// update()
		/*
		Student student1 = new Student(101,"Divesh", 60.0, Gender.MALE, LocalDate.of(2003,03,16));
		service.updateStudent(student1);
		System.out.println("Student updated");
		*/
		
		//save or update
		/*
		Student student1 = new Student(104,"DDD", 66.0, Gender.FEMALE, LocalDate.of(2009,12,16));
		service.saveOrUpdateStudent(student1);
		System.out.println("Student Updated or Saved");
		
		Student student2 = new Student(102,"BBB", 81.20, Gender.MALE, LocalDate.of(2021,8,15));
		service.saveOrUpdateStudent(student2);
		System.out.println("Student Updated or Saved");
		*/
		
		// fetch by Id
		/*
		Optional<Student> ob = service.fetchById(101);
		if(ob.isPresent())
		{
			Student student = ob.get();
			System.out.println(student);
		}
		*/
		
		// fetch all
		/*
		List<Student> students = service.fetchAllStudent();
		if(students.isEmpty())
		{
			System.out.println("Students not found");
		}
		else
		{
			printStudent(students);
		}
		*/
		
		// delete student by Id
		/*
		boolean status = service.deleteStudentById(104);
		if(status)
		{
			System.out.println("Student deleted");
		}
		else
		{
			System.out.println("Student not found");
		}
		*/
		
		/*
		Student s1 = new Student(104,"DDD", 35.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		Student s2 = new Student(105,"EEE", 55.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		Student s3 = new Student(106,"FFF", 23.0, Gender.FEMALE, LocalDate.now());
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		List<Student> updated = service.saveAll(students);
		printStudent(updated);
		*/
		
		// Complete the assignment
		
		// count of records
		/*
		System.out.println(service.count());
		*/
		
		
		// delete student - entity
		/*
		Student s1 = new Student(104,"DDD", 35.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		System.out.println(service.deleteStudent(s1) ? "Student deleted" : "Student not deleted");
		*/
		
		// delete all students
		/*
		System.out.println(service.deleteAllStudent() ? "Deleted all students" : "Students not found");
		System.out.println(service.deleteAllStudent() ? "Deleted all students" : "Students not found");
		*/
		
		
		// delete student - entity through list
		/*
		
		Student s1 = new Student(104,"DDD", 35.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		Student s2 = new Student(105,"EEE", 55.0, Gender.MALE, LocalDate.of(2026, 8, 24));
		Student s3 = new Student(106,"FFF", 23.0, Gender.FEMALE, LocalDate.now());
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		System.out.println(service.deleteStudents(students) ? "Students deleted" : "Students not deleted");
		System.out.println(service.deleteStudents(students) ? "Students deleted" : "Students not deleted");
		*/
		
		// delete students through list of ids
		
		List<Integer> ids = List.of(101,102,103);
		System.out.println(service.deleteStudentsById(ids) ? "Students deleted" : "Students not deleted");
		

	
	}

}
