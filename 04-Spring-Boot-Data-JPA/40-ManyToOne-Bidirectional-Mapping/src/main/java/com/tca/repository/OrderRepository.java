package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tca.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
	@Modifying
	@Transactional
	@Query("update Order o SET o.customer = null WHERE o.oid=:oid")
	public void softDelete(Long oid);
}
