package com.tca.beans;

public class Customer 
{
	private int customerId;
	private String customerName;
	private Address address;
	
	
	
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public void setAddress(Address address) {
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
