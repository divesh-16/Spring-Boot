package com.tca.service;

import com.tca.entities.Customer;
import com.tca.entities.Order;

public interface CustomerService 
{
	public Customer saveCustomer(Customer c);
	public Customer fetchCustomerById(Long id);
	
	public void updateOrderForCustomer(Order o, Long cid);
	public void deleteCustomerById(Long id);
}
