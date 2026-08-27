package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.WelcomeBean;

public class App {
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        WelcomeBean wc = (WelcomeBean) context.getBean("welcomeBean");
        System.out.println(wc.getMessage());
        System.out.println(wc.getId());
    	
    }
}
