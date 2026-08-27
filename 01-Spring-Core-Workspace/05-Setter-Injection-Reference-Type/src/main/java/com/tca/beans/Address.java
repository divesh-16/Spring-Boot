package com.tca.beans;

public class Address 
{
	private int pincode;
	private String city;
	
	
	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode()
	{
		return pincode;
	}
	
	public String getCity()
	{
		return city;
	}
}
