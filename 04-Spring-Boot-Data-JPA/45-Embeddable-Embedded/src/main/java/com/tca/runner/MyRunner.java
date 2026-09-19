package com.tca.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Employee;
import com.tca.model.Address;
import com.tca.service.EmployeeService;

@Component
public class MyRunner implements ApplicationRunner 
{
	@Autowired
	EmployeeService employeeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*		
		Address a = new Address();
		a.setHouseNumber("111");
		a.setCity("Pune");
		a.setStreet("GaneshKhind");
		a.setPincode("411007");
		
		Employee emp = new Employee();
		emp.setName("AAA");
		emp.setSalary(35000.0);
		emp.setAddress(a);
		
		emp = employeeService.saveEmployee(emp);
		System.out.println("Employee saved with id : "+emp.getEid());
*/
/*		
		Employee emp = employeeService.fetchById(1L);
		System.out.println(emp);
*/
		employeeService.removeEmployee(1L);
		
	}

}
