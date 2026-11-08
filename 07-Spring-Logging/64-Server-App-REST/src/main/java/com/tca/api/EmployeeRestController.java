package com.tca.api;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.tca.exception.EmployeeAlreadyExistException;
import com.tca.exception.EmployeeNotFoundException;
import com.tca.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmployeeRestController 
{
	@Autowired
	private EmployeeService service;
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

	@GetMapping(value="/employee/{id}", produces= {"application/json","application/xml"})
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		log.info("GET /employee/{} - Request Received",id);
		Employee emp = service.fetchEmployeeById(id);
		//System.out.println(emp);
		
		if(emp == null)
		{
			log.warn("GET /employees/{} not Found",id);
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			throw new EmployeeNotFoundException("Employee with id : "+id+" does not exists");
		}
		else
		{
			log.info("GET /employee/{} - Employee found: {}", id, emp.getName());
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		log.info("GET /employees - Fetching all employees");
		List<Employee> emps = service.fetchAllEmployee();
		
		if(emps.isEmpty())
		{
			log.warn("GET /employees - No Employees in Database");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			log.info("GET /employees - Total employees fetched : "+emps.size());
			log.debug("GET /employees - emps : "+emps);
			return new ResponseEntity<>(emps,HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/add" /*consumes= {"application/xml", "application/json"}, produces= {"application/xml", "application/json"}*/ )
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		log.info("POST /add - Request to add Employee : eno:{}, name:{}, salary:{}, deptno:{}",emp.getEno(),emp.getName(),emp.getSalary(),emp.getDeptno());
		log.debug("POST /add - full request body : "+emp);
		Employee saveEmployee = service.addEmployee(emp);
		
		if(saveEmployee == null)
		{
			log.warn("POST /add - Employee already exists with eno={}", emp.getEno());
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			throw new EmployeeAlreadyExistException("Employee with id : "+emp.getEno()+" already exists");
		}
		else
		{
			log.info("POST /add - Employee added with eno : "+saveEmployee.getEno());
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
	{
		log.info("DELETE /delete{} - Request Received",id);
		
		boolean isDeleted = service.deleteEmployeeById(id);
		if(isDeleted)
		{
			log.info("DELETE /delete {} - Employee deleted successfully",id);
			return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
		}
		else
		{
			log.warn("DELETE /delete/{} - Employee NOT FOUND, cannot delete", id);
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		log.info("PUT /update - Request to update employee: empno={}", emp.getEno());
		
        log.debug("PUT /update - Full update payload: {}", emp);
		Employee updatedEmployee = service.updateEmployee(emp);
		if(updatedEmployee == null)
		{
			log.warn("PUT /update - Employee NOT FOUND with empno={}", emp.getEno());
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			throw new EmployeeNotFoundException("Employee with id : "+emp.getEno()+" does not exists");
		}
		else
		{
			log.info("PUT /update - Employee updated successfully: empno={}", updatedEmployee.getEno());
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		}
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Map<String, Object> map, @PathVariable Integer id)
	{
		Employee emp = service.modifyEmployee((String)map.get("name"),(Double)map.get("salary"), id);
		log.info("PATCH /update/{} - Partial update request", id);
		log.debug("PATCH /update/{} - Fields to update: {}", id, map);
		if(emp == null)
		{
			log.warn("PATCH /update/{} - Employee NOT FOUND", id);
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new EmployeeNotFoundException("Employee with id : "+id+" does not exists");
		}
		else
		{
			 log.info("PATCH /update/{} - Partial update successful", id);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
	}
}
