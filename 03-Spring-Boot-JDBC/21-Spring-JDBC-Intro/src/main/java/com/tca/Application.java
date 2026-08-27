package com.tca;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tca.model.Student;
import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Student student1 = new Student(101,"PPP",60.0,"Pune");
		Student student2 = new Student(102,"QQQ",65.0,"Pune");
		Student student3 = new Student(103,"RRR",70.0,"Mumbai");
		Student student4 = new Student(104,"SSS",90.0,"Delhi");
		
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		studentRepository.saveStudent(student1);
		studentRepository.saveStudent(student2);
		studentRepository.saveStudent(student3);
		studentRepository.saveStudent(student4);
		//studentRepository.deleteStudent(101);
		//studentRepository.updateStudent(student);
		
		Map<String, Object> map = studentRepository.getStudentById(101);
		System.out.println(map);
		
		List<Map<String, Object>> students = studentRepository.getAllStudent();
		System.out.println(students);
	}

}
