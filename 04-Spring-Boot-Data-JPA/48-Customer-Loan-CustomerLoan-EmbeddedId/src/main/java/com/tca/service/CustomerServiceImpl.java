package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Customer;
import com.tca.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer saveCustomer(Customer c) 
	{
		return repo.save(c);
	}

	@Override
	public Customer fetchById(Long id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public void removeCustomer(Long id) 
	{
		repo.deleteById(id);
	}

}
