package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tca.model.Student;
import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Student student = new Student(101,"AAA",88.0,"Pune");
		
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		//studentRepository.saveStudent(student);
		//studentRepository.deleteStudent(102);
		studentRepository.updateStudent(student);
	}

}
