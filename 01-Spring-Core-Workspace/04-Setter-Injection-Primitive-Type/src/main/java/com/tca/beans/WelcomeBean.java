package com.tca.beans;

public class WelcomeBean 
{
	private int id;
	private String message;
	
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setMessage(String message) {
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
