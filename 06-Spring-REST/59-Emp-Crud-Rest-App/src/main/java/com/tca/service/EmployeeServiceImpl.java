package com.tca.service;

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
	public Employee fetchEmployeeById(Integer id) 
	{
		if(repo.existsById(id))
		{
			return repo.findById(id).get();
		}
		else
		{
			return null;
		}
	}
}
