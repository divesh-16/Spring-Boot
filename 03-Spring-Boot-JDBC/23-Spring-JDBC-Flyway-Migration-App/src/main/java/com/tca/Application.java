package com.tca;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository repo = context.getBean(StudentRepository.class);
		
		List<Map<String, Object>> list = repo.getAllStudent();
		
		System.out.println(list);
	}

}
