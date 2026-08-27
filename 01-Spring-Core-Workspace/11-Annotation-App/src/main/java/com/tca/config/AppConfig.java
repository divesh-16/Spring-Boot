package com.tca.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tca.model.Student;

@Configuration
@ComponentScan("com.tca")
public class AppConfig 
{
	@Bean
	public Map<String, Student> getStudentStore()
	{
		Student s1 = new Student(101,"AAA","Pune",55.0);
		Student s2 = new Student(102,"BBB","Mumbai",65.0);
		Student s3 = new Student(103,"CCC","Panji",70.0);
		Student s4 = new Student(104,"DDD","Banglore",75.0);
		Student s5 = new Student(105,"EEE","Pune",80.0);
		
		Map<String, Student> map = new HashMap<>();	
		
		
		map.put("SB1",s1);
		map.put("SB2",s2);
		map.put("SB3",s3);
		map.put("SB4",s4);
		map.put("SB5",s5);
		
		return map;
	}
}
