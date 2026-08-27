package com.tca;

import com.tca.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tca.model.Student;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		//Student student = new Student(101,"Divesh",70,"Pune");
		StudentRepository repo = context.getBean(StudentRepository.class);
		//repo.saveStudent(student);
		System.out.println(repo.getStudentById(101));
	}

}
