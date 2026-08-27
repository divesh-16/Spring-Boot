package com.tca.beans;

public class Customer 
{
	private int customerId;
	private String customerName;
	private Address address;
	
	public Customer(int customerId, String customerName, Address address) 
	{
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	
	public String getCustomerName() {
		return customerName;
	}


	public Address getAddress() {
		return address;
	}
		
	
}
