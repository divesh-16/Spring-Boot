package com.tca.service;

import com.tca.entity.Customer;

public interface CustomerService 
{
	public Customer saveCustomer(Customer c);
	public Customer fetchById(Long id);
	
	public void removeCustomer(Long id);
}
