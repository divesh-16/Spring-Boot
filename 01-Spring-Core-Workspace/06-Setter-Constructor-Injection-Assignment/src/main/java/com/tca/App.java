package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        Student student = (Student)context.getBean("student");
        
        System.out.println(student.getRno());
        System.out.println(student.getName());
        System.out.println(student.getFees());
        System.out.println(student.getPassport());
        
        
    }
}
