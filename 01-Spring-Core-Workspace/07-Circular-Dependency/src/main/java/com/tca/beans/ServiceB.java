package com.tca.beans;

public class ServiceB 
{
	ServiceA serviceA;
	
	public ServiceB(ServiceA serviceA)
	{
		this.serviceA = serviceA;
		System.out.println("Constructor Injection : B");
	}
	
	public void setServiceA(ServiceA serviceA)
	{
		this.serviceA = serviceA;
		System.out.println("Setter Injection : B");
	}
}
