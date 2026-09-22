package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
