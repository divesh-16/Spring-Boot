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
	public Employee saveEmployee(Employee emp) 
	{
		return repo.save(emp);
	}

	@Override
	public Employee fetchById(Long id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public void removeEmployee(Long id) 
	{
		repo.deleteById(id);
	}
	
	
}
