package com.tca.beans;

public class ServiceA 
{
	ServiceB serviceB;
	
	public ServiceA()
	{
		System.out.println("0-Arg Constructor : A");
	}
	

	public void setServiceB(ServiceB serviceB) 
	{
		this.serviceB = serviceB;
		System.out.println("Setter Injection : A");
	}
	

	
}
