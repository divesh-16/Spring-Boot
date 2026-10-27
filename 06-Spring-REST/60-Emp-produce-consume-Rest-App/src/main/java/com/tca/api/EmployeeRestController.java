package com.tca.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tca.entity.Employee;
import com.tca.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmployeeRestController 
{
	@Autowired
	private EmployeeService service;

	@GetMapping(value ="/employee/{id}",
				produces = "application/xml")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		Employee emp = service.fetchEmployeeById(id);
		//System.out.println(emp);
		
		if(emp == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/employees", produces="application/xml")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> emps = service.fetchAllEmployee();
		
		if(emps.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<>(emps,HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/add",
			consumes= {"application/xml","application/json"},
			produces= {"application/xml","application/json"})
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		Employee saveEmployee = service.addEmployee(emp);
		
		if(saveEmployee == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
	{
		boolean isDeleted = service.deleteEmployeeById(id);
		if(isDeleted)
		{
			return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/update", consumes="application/xml", produces="application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		Employee updatedEmployee = service.updateEmployee(emp);
		if(updatedEmployee == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		}
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Map<String, Object> map, @PathVariable Integer id)
	{
		Employee emp = service.modifyEmployee((String)map.get("name"),(Double)map.get("salary"), id);
		
		if(emp == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
	}
}
