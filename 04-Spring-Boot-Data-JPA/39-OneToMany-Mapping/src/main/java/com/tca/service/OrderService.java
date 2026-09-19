package com.tca.service;

import com.tca.entities.Order;
import com.tca.entities.OrderStatus;

public interface OrderService 
{
	public Order fetchOrderById(Long oid);
	
	public Order updateOrderStatus(Order o);
}
