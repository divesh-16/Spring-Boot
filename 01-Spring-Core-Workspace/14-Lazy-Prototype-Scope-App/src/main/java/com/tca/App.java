package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.ServiceA;
import com.tca.config.AppConfig;

/**
 * Hello world!
 */
public class App {
	
/*	
	//Early Loading and Singleton scope
    public static void main(String[] args) 
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    }
 */   

/*	
	// Lazy Loading and Singleton scope
	// Object is not created in container till the time it is not referred
	public static void main(String[] args) 
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
        
    }
*/
	// Lazy Loading and Prototype loading
	public static void main(String[] args) 
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
        
        ServiceA ob1 = context.getBean(ServiceA.class);
        System.out.println(ob1);
        System.out.println("Name of ob1 : "+ob1.getBeanName());
//        ServiceA ob2 = context.getBean(ServiceA.class);
//        System.out.println(ob2);
        /*
         // Output
         	ServiceA 0-Arg Constructor
			com.tca.beans.ServiceA@d83da2e
			ServiceA 0-Arg Constructor
			com.tca.beans.ServiceA@a4102b8
         
         */
        
        // If I want to know Name/ID of Bean given to beans by container then I can use BeanNameAware interface.
        
        
//        System.out.println("Name of ob2 : "+ob2.getBeanName());
        
        
        ((AnnotationConfigApplicationContext)context).close();
    }
	
}
