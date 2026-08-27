package com.tca;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		StudentRepository repo = context.getBean(StudentRepository.class);
		
		String grade = repo.getStudentGrade(101);
		System.out.println(grade);
	}
	
	
	@Bean
	public SimpleJdbcCall getSimpleJdbcCall(DataSource source)
	{
		// return new SimpleJdbcCall(source).withFunctionName("get_grade");
		return new SimpleJdbcCall(source);
	}

}
