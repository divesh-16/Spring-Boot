package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.Address;
import com.tca.beans.Customer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
//        Address address = (Address) context.getBean("addr");
//        System.out.println(address.getPincode());
//        System.out.println(address.getCity());
        
        Customer c = (Customer) context.getBean("customer");
        System.out.println(c.getCustomerId());
        System.out.println(c.getCustomerName());
        System.out.println(c.getAddress().getPincode());
        System.out.println(c.getAddress().getCity());
        
    }
}
