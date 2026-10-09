package com.tca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Employee;
import com.tca.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> fetchAllEmployee() 
	{
		return repo.findAll();
	}

}
