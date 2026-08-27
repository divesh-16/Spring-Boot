package com.tca.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
