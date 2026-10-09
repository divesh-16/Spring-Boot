package com.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tca.entity.Employee;
import com.tca.service.EmployeeService;

@Controller
@RequestMapping("/employee")
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
	
	@GetMapping("/getPage")
	public String getPage(@RequestParam("pgNo") int pgNo, Model model)
	{
		
		Page<Employee> page = service.fetchAllEmployee(pgNo);
		
		List<Integer> pgList = service.getPageNumberList(page.hasPrevious(), page.hasNext(), pgNo, page.getTotalPages());
		
		model.addAttribute("emps", page.toList());
		model.addAttribute("pgList", pgList);
		model.addAttribute("currPgNo", pgNo);	// current pg
		model.addAttribute("hasPrevious", page.hasPrevious());
		model.addAttribute("hasNext", page.hasNext());
		
		return "showEmployees";
	}
}
