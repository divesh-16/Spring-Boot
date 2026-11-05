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
	
	@Override
	public List<Employee> fetchAllEmployee() 
	{
		return repo.findAll();
	}
	
	@Override
	public Employee addEmployee(Employee emp) 
	{
		if(repo.existsById(emp.getEno()))
		{
			return null;
		}
		else
		{
			return repo.save(emp);
		}
	}
	
	@Override
	public boolean deleteEmployeeById(Integer id) 
	{
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public Employee updateEmployee(Employee emp) 
	{
		if(repo.existsById(emp.getEno()))
		{
			return repo.save(emp);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Employee modifyEmployee(String name, Double salary, Integer eno) 
	{
		if(repo.existsById(eno))
		{
			repo.modifyEmployee(name, salary, eno);
			
			return repo.findById(eno).get();
		}
		else
		{
			return null;
		}
	}
}
