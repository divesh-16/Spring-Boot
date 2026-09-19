package com.tca.service;

import com.tca.entities.Customer;
import com.tca.entities.Order;

public interface OrderService 
{
	public Order fetchOrderById(Long oid);
	public Order saveOrder(Order o, Customer c);
	
	public Order updateOrderStatus(Order o);
	
	public void deleteOrderById(Long id);
	
	public void softDelete(Long id);
}
