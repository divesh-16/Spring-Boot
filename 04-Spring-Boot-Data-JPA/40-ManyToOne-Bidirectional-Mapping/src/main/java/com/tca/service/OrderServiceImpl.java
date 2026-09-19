package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entities.Customer;
import com.tca.entities.Order;
import com.tca.entities.OrderStatus;
import com.tca.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService 
{
	@Autowired
	OrderRepository repo;
	
	@Override
	public Order fetchOrderById(Long oid) 
	{
		return repo.findById(oid).get();
	}
	
	@Override
	public Order updateOrderStatus(Order o) 
	{
		return repo.save(o);
	}
	
	@Override
	public Order saveOrder(Order o, Customer c) 
	{
		o.setCustomer(c);
		
		return repo.save(o);
	}
	
	@Override
	public void deleteOrderById(Long id) 
	{	
		repo.deleteById(id);
	}
	
	@Override
	public void softDelete(Long id) 
	{
		repo.softDelete(id);	
	}
}
