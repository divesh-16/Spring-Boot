package com.tca.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
	// Early Loading and Singleton scope
@Component
public class ServiceA 
{
	public ServiceA()
	{
		System.out.println("ServiceA 0-Arg Constructor");
	}
}
*/

/*
// Lazy Loading and Singleton Scope	
@Component
@Lazy
public class ServiceA 
{
	public ServiceA()
	{
		System.out.println("ServiceA 0-Arg Constructor");
	}
}
*/

/*
	// Lazy Loading and Prototype Scope (NEW object for every getBean() call)
@Component
@Scope("prototype")
public class ServiceA 
{
	public ServiceA()
	{
		System.out.println("ServiceA 0-Arg Constructor");
	}
}

*/


// As beans are created based on class name then what will be name of beans of same classes ?
// Ans : To know this we can use interface BeanNameAware where we can know name/id assigned to bean by Spring container.
/*
@Component
@Scope("prototype")
public class ServiceA implements BeanNameAware
{
	String name;
	public ServiceA()
	{
		System.out.println("ServiceA 0-Arg Constructor");
	}

	@Override
	public void setBeanName(String name) 
	{		
		this.name = name;
	}
	
	public String getBeanName()
	{
		return name;
	}
}
*/

@Component
@Scope("prototype")
public class ServiceA implements BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean
{
	private int data;
	private String beanName;
	private ApplicationContext context;
	
	public ServiceA()
	{
		System.out.println("Object Creation");
	}
	
	public void setData(int data)
	{
		this.data = data;	
		System.out.println("Setter injection");
	}
	
	public int getData()
	{
		return data;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		this.context = context;
		System.out.println("Application Context set by Spring container");
	}

	@Override
	public void setBeanName(String name) 
	{
		this.beanName = name;
		System.out.println("Name set by Spring container : "+name);
	}
	
	public String getBeanName()
	{
		return beanName;
	}

	@Override
	public void destroy() throws Exception 
	{
		System.out.println("Destroy : Destroying");
	}

	@Override
	public void afterPropertiesSet() throws Exception 
	{
		System.out.println("Afterproperties : Initializing ");
	}
	
	public void init()
	{
		System.out.println("My Init : Initializing ");
	}
	
	public void myDestroy()
	{
		System.out.println("My Destroy : Destroying ");
	}
	
}