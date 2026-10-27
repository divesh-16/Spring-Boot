package com.tca.runner;


import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tca.model.Employee;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired(required=true)
	RestTemplate rt;
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		// getForObject
		/*
		Employee emp = rt.getForObject("http://localhost:8081/employee/{id}", Employee.class, 101);
		ResponseEntity<Employee> entity = rt.getForEntity("http://localhost:8081/employee/{id}", Employee.class, 101);
		
		System.out.println(emp);
		
		System.out.println(entity);
		*/
		
		/*
		ResponseEntity<Employee> entity = rt.getForEntity("http://localhost:8081/employee/{id}", Employee.class, 101);
		
		HttpStatusCode status = entity.getStatusCode();
		if(status.is2xxSuccessful())
		{
			Employee emp = entity.getBody();
			System.out.println(emp);
			
		}
		*/
		
		//Calling get via exchange() method
		/*
		ResponseEntity<Employee> entity = rt.exchange("http://localhost:8081/employee/{id}",		// url or end point to call 
														HttpMethod.GET,									// method type
														null,											// request body, for it is null
														Employee.class,									// response type
														101);
		HttpStatusCode status = entity.getStatusCode();
		if(status.is2xxSuccessful())
		{
			Employee emp = entity.getBody();
			System.out.println(emp);
			
		}
		
		*/
		
		
		// Calling GET /employee/{id} via exchange() By Setting Headers
		/*
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/xml");
		
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(headers);
		
		ResponseEntity<Employee> entity = rt.exchange("http://localhost:8081/employee/{id}", 
														HttpMethod.GET, 
														requestEntity, 
														Employee.class,
														101);
		
		HttpStatusCode status = entity.getStatusCode();

		if(status.is2xxSuccessful())
		{
			Employee emp = entity.getBody();
			System.out.println("Employees Data :" + emp);
		}
		*/
		
		// Post /add : calling via exchange()
		/*
		Employee emp = new Employee();
		emp.setEno(136);
		emp.setName("ZZZ");
		emp.setDeptno(555);
		emp.setSalary(10000.0);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/xml");
		headers.add("Accept", "application/xml");
		
		HttpEntity<Employee> requestEntity = new HttpEntity<>(emp, headers);
		
		ResponseEntity<Employee> entity = rt.exchange("http://localhost:8081/add", 
				HttpMethod.POST, 
				requestEntity, 
				Employee.class
				);
		
		HttpStatusCode status = entity.getStatusCode();

		if(status.is2xxSuccessful())
		{
			emp = entity.getBody();
			System.out.println("Employees Data :" + emp);
		}
		*/
		
		// put /update : calling via exchange()
		/*
		Employee emp = new Employee();
		emp.setEno(102);
		emp.setName("Disha");
		emp.setDeptno(333);
		emp.setSalary(20000.0);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/xml");
		headers.add("Accept", "application/xml");
		
		HttpEntity<Employee> requestEntity = new HttpEntity<>(emp, headers);
		
		ResponseEntity<Employee> entity = rt.exchange("http://localhost:8081/update", 
				HttpMethod.PUT, 
				requestEntity, 
				Employee.class
				);
		
		HttpStatusCode status = entity.getStatusCode();

		if(status.is2xxSuccessful())
		{
			emp = entity.getBody();
			System.out.println("Employees Data :" + emp);
		}
		*/
		
		ResponseEntity<String> entity = rt.exchange("http://localhost:8081/delete/{id}",		// url or end point to call 
				HttpMethod.DELETE,									// method type
				null,											// request body, for it is null
				String.class,									// response type
				136);

		HttpStatusCode status = entity.getStatusCode();
		if(status.is2xxSuccessful())
		{
			String str = entity.getBody();
			System.out.println(str);
		}
		
		
		
	}
}
