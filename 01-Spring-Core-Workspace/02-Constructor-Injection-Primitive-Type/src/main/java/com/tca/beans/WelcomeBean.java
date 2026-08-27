package com.tca.beans;

public class WelcomeBean 
{
	private int id;
	private String message;
	
	public WelcomeBean(int id, String message)
	{
		this.id = id;
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public int getId()
	{
		return id;
	}
}
