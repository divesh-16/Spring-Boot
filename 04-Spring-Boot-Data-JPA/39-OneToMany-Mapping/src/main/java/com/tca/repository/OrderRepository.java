package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{

}
