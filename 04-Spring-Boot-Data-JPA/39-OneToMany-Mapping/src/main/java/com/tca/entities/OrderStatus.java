package com.tca.entities;

public enum OrderStatus 
{
	ORDERED("ordered"),
	PROCESSED("processed"),
	RECEIVED("received"),
	REFUNDED("refunded"),
	CANCELLED("cancelled");
	
	private String s;
	
	private OrderStatus(String s)
	{
		this.s = s;
	}
}
