package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.config.AppConfig;
import com.tca.service.StudentService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       
       StudentService studentService = context.getBean(StudentService.class);
       
       System.out.println(studentService.getStudent("SB1"));
       
       for(String key : studentService.getAllStudent().keySet())
       {
    	   System.out.println(studentService.getAllStudent().get(key));
       }
       
    }
}
