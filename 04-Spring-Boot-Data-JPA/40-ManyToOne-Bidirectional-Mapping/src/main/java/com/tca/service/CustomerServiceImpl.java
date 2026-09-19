package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entities.Customer;
import com.tca.entities.Order;
import com.tca.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	CustomerRepository repo;
	
	@Override
	public Customer saveCustomer(Customer c) 
	{
		return repo.save(c);
	}
	
	@Override
	public Customer fetchCustomerById(Long id) 
	{
		return repo.findById(id).get();
	}
	
	@Override
	public void updateOrderForCustomer(Order o, Long cid) 
	{
		repo.updateOrder(o.getOid(), o.getOrderDate(), o.getStatus(), cid);
	}
	
	@Override
	public void deleteCustomerById(Long id) 
	{
		repo.deleteById(id);
	}
}
