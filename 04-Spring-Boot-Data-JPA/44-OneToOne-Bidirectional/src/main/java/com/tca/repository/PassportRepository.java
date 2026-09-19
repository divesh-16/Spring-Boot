package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long>
{	

}
