package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.ReportManager;

/**
 * Hello world!
 */
public class App {
    private static final String ReportManager = null;

	public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        ReportManager rm = (ReportManager) context.getBean("reportManager");
        rm.printReport();
        
    }
}
