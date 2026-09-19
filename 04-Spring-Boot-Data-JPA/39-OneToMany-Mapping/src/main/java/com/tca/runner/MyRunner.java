package com.tca.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tca.entities.Customer;
import com.tca.entities.Order;
import com.tca.entities.OrderStatus;
import com.tca.service.CustomerService;
import com.tca.service.OrderService;

@Component
public class MyRunner implements ApplicationRunner 
{
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	

	@Modifying
	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		// save customer with order
/*
		Customer c = new Customer();
		c.setName("AAA");
		c.setPhone("9999");
		
		Order o1 = new Order();
		o1.setOid(101L);
		o1.setOrderDate(LocalDate.now());
		o1.setStatus(OrderStatus.ORDERED);
		
		Order o2 = new Order();
		o2.setOid(102L);
		o2.setOrderDate(LocalDate.now());
		o2.setStatus(OrderStatus.RECEIVED);
		
		c.setOrders(List.of(o1, o2));
		
		c = customerService.saveCustomer(c);
		
		System.out.println("Customer save with id "+c.getCid());
*/
/*	
		Customer c = new Customer();
		c.setName("BBB");
		c.setPhone("8888");
		
		c = customerService.saveCustomer(c);
		
		System.out.println("Customer save with id "+c.getCid());
*/
/*		
		Customer c = customerService.fetchCustomerById(1L);
		
		System.out.println("Customer ID    : " + c.getCid());
		System.out.println("Customer Name  : " + c.getName());
		System.out.println("Customer Phone : " + c.getPhone());
		
		System.out.println("----------------------------------------------------------");
		
		List<Order> orders = c.getOrders();
		System.out.println(orders);
*/

/*
		Customer c = customerService.fetchCustomerById(2L);
		System.out.println("Customer ID    : " + c.getCid());
		System.out.println("Customer Name  : " + c.getName());
		System.out.println("Customer Phone : " + c.getPhone());
		
		System.out.println("----------------------------------------------------------");
		customerService.updateOrderForCustomer(new Order(103L, LocalDate.now(), OrderStatus.ORDERED), c.getCid());
		
		List<Order> orders = c.getOrders();
		System.out.println(orders);
*/
/*		
		// delete customer by id
		customerService.deleteCustomerById(1L);
*/
/*
		Order order = orderService.fetchOrderById(102L);  // order = 102 2026-09-11 RECEIVED
		System.out.println(order);
		order.setStatus(OrderStatus.CANCELLED); // Order Status is updated at database too
		
		//order = orderService.updateOrderStatus(order); //order = 102 2026-09-11 CANCELLED
		
		System.out.println(order);
*/
/*		
		Customer c = customerService.fetchCustomerById(3L);
		c.setName("Divesh");  // Customer name is updated at database too
		System.out.println(c);
*/
/*		
		Customer c = customerService.fetchCustomerById(2L); // 2 BBB 888  o103
		
		List<Order> orders = c.getOrders();  // orders ->[102 ....]
		orders.add(new Order(103L, LocalDate.now(), OrderStatus.RECEIVED));
				
		System.out.println(c);
*/	
		
		Customer c = customerService.fetchCustomerById(3L);  // 4   orders=[101] [102]
		c.getOrders().remove(0);
		
	}

}
