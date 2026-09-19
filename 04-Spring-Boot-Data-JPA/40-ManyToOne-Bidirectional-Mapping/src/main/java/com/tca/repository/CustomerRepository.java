package com.tca.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tca.entities.Customer;
import com.tca.entities.OrderStatus;

public interface CustomerRepository extends JpaRepository<Customer, Long> 
{
	@Modifying
	@Transactional
	@Query(value="insert into orders values(:oid, :date, :status, :custid)", nativeQuery = true)
	public void updateOrder(Long oid, LocalDate date, OrderStatus status, Long custid);
}
