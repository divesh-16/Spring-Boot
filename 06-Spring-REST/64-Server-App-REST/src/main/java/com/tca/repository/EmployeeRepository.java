package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tca.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	@Query(value="update employee set name=?, salary=? where eno=?", nativeQuery=true)
	@Transactional
	@Modifying
	public int modifyEmployee(String name, Double salary, Integer eno);
}
