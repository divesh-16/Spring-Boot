package com.tca.service;

import java.util.List;

import com.tca.entity.Employee;

public interface EmployeeService 
{
	public Employee fetchEmployeeById(Integer id);
	public List<Employee> fetchAllEmployee();
	
	public Employee addEmployee(Employee emp);
	
	public boolean deleteEmployeeById(Integer id);
	public Employee updateEmployee(Employee emp);
	
	public Employee modifyEmployee(String name, Double salary, Integer eno);
	
}
