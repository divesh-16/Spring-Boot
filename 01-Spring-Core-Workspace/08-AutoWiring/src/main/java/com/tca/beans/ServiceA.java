package com.tca.beans;

public class ServiceA 
{
	ServiceB serviceB;
	
	public ServiceA()
	{
		System.out.println("0-arg constructor of Service A");
	}
	
	public ServiceA(ServiceB serviceB)
	{
		this.serviceB = serviceB;
		System.out.println("parameter constructor of Service A");
	}
	

	public void setServiceB(ServiceB serviceB) 
	{
		this.serviceB = serviceB;
		System.out.println("Setter Injection of A, injecting B");
	}
	
	
}
