package com.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tca.entity.Employee;
import com.tca.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	
	@GetMapping("/getAll")
	public String getAllEmployee(Model model)
	{
		List<Employee> list = service.fetchAllEmployee();
		model.addAttribute("emps", list);
		
		return "showEmployees";
		
	}
}
