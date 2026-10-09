package com.tca.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tca.entity.Employee;

public interface EmployeeService 
{
	public List<Employee> fetchAllEmployee();
	public Page<Employee> fetchAllEmployee(int PgNo);
	
	public List<Integer> getPageNumberList(boolean hasPrevious, boolean hasNext, int curr, int totalPages);
}
