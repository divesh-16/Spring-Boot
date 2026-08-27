package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.ServiceA;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        ServiceA sa = context.getBean(ServiceA.class);
        System.out.println(sa.getData());
        
        ((ClassPathXmlApplicationContext)context).close();
    }
}
