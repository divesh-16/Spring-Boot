package com.tca.service;

import com.tca.entity.Employee;

public interface EmployeeService 
{
	public Employee saveEmployee(Employee emp);
	public Employee fetchById(Long id);
	public void removeEmployee(Long id);
}
