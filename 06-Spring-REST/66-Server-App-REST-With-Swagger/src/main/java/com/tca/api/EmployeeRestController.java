package com.tca.api;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tca.entity.Employee;
import com.tca.exception.EmployeeAlreadyExistException;
import com.tca.exception.EmployeeNotFoundException;
import com.tca.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin(origins = "http://localhost:5173")


@RestController
@Tag(name = "User Management", description = "Endpoints for managing user accounts")
public class EmployeeRestController 
{
	@Autowired
	private EmployeeService service;

	@Operation(summary = "Get employee details by ID", description = "Retrieves a employee data by unique identifier")
	@GetMapping(value="/employee/{id}", produces= {"application/json","application/xml"})
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		Employee emp = service.fetchEmployeeById(id);
		//System.out.println(emp);
		
		if(emp == null)
		{
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			throw new EmployeeNotFoundException("Employee with id : "+id+" does not exists");
		}
		else
		{
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}
	
	@Operation(summary = "Get all employee details", description = "Retrieves all employees data from database")
	@GetMapping(value="/employees", produces= {"application/xml", "application/json"})
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
	
	@Operation(summary="Saves Employee details - eno,name,salary,deptno in database", description="Saves Employee(int eno,String name,double salary, int deptno)")
	@PostMapping(value="/add", consumes= {"application/xml", "application/json"}, produces= {"application/xml", "application/json"})
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		Employee saveEmployee = service.addEmployee(emp);
		
		if(saveEmployee == null)
		{
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			throw new EmployeeAlreadyExistException("Employee with id : "+emp.getEno()+" already exists");
		}
		else
		{
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		}
	}
	
	@Operation(summary="Deletes employee with given id as uri variable",description="Deletes employee record with given integer ID")
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
	
	@Operation(summary="Updates the Employee who's details(eno, name, salary, deptno) are provided", description="Provide the Employee in json/xml to update the information.")
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		Employee updatedEmployee = service.updateEmployee(emp);
		if(updatedEmployee == null)
		{
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			throw new EmployeeNotFoundException("Employee with id : "+emp.getEno()+" does not exists");
		}
		else
		{
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		}
	}
	
	@Operation(summary="Updates the Employee's name and salary whose id is provided through uri parameter",description="Provide the id in uri and name and salary in body to update the details.")
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Map<String, Object> map, @PathVariable Integer id)
	{
		Employee emp = service.modifyEmployee((String)map.get("name"),(Double)map.get("salary"), id);
		
		if(emp == null)
		{
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new EmployeeNotFoundException("Employee with id : "+id+" does not exists");
		}
		else
		{
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
	}
}
