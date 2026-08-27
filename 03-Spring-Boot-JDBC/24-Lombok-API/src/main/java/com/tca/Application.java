package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tca.model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		Student s = new Student(16032003);
		s.setRno(101);
		s.setPer(60);
		s.setName("AAA");
		
		System.out.println(s);
	}

}
