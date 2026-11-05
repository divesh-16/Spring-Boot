package com.tca.runner;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.tca.model.Employee;
import com.tca.util.MyAppUtil;

import reactor.core.publisher.Mono;

@Component
public class MyRunner implements ApplicationRunner
{
	@Autowired(required=true)
	WebClient webClient;
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		// calling get /employee/{id}
		/*
		Mono<Employee> empMono = webClient.get()
		.uri(MyAppUtil.GET_EMP_URL, 101)
		.retrieve()
		.bodyToMono(Employee.class);
		
		empMono.subscribe(emp -> System.out.println(emp));
		*/
		// calling get /employee/{id} with exception
		/*
		Mono<Employee> empMono = webClient.get()
		.uri(MyAppUtil.GET_EMP_URL, 555)
		.retrieve()
		.bodyToMono(Employee.class);
		
		empMono.subscribe(emp -> System.out.println(emp),
				ex -> {
					System.out.println("Employee Not Found ");
					
					
					if(ex instanceof WebClientResponseException)
					{
						WebClientResponseException wex = (WebClientResponseException) ex;
						System.out.println("Status Code : " + wex.getStatusCode());
			        	System.out.println("Message     : " + wex.getResponseBodyAsString());
					}
					
				});
		
		*/
		
		//calling get /employees
/*		
		Flux<Employee> empFlux = webClient.get()
		.uri(MyAppUtil.GET_ALL_EMP_URL)
		.retrieve()
		.bodyToFlux(Employee.class);
	
		empFlux.subscribe(emp ->{
			//emp.setName(emp.getName()+"HIHIH");
			System.out.println(emp);
			System.out.println("-".repeat(50));
		});
*/
		
		
		// calling post /add
/*
		Employee e = new Employee();
		e.setEno(101);
		e.setDeptno(126);
		e.setName("VVV");
		e.setSalary(33000.0);
		
		
		Mono<Employee> empMono = webClient.post()
										.uri(MyAppUtil.ADD_EMP_URL)
										.bodyValue(e)
										.retrieve()
										.bodyToMono(Employee.class);
		
		empMono.subscribe(emp ->System.out.println(emp),
							ex -> {
							System.out.println("Employee Not Found ");
							
							
							if(ex instanceof WebClientResponseException)
							{
								WebClientResponseException wex = (WebClientResponseException) ex;
								System.out.println("Status Code : " + wex.getStatusCode());
					        	System.out.println("Message     : " + wex.getResponseBodyAsString());
							}
			
		});
*/
		
		// calling put /update
/*		
		Employee e = new Employee();
		e.setEno(105);
		e.setName("Ethan");
		e.setSalary(50000.0);
		e.setDeptno(555);
		
		Mono<Employee> empMono = webClient.put()
										.uri(MyAppUtil.UPDATE_EMP_URL)
										.bodyValue(e)
										.retrieve()
										.bodyToMono(Employee.class);
		
		empMono.subscribe(emp -> System.out.println(emp),
				ex-> {
					System.out.println("Employee Not Found ");
					
					
					if(ex instanceof WebClientResponseException)
					{
						WebClientResponseException wex = (WebClientResponseException) ex;
						System.out.println("Status Code : " + wex.getStatusCode());
			        	System.out.println("Message     : " + wex.getResponseBodyAsString());
					}
				});
*/
		// calling delete /delete{id}
/*		
		Mono<String> mono = webClient.delete()
		.uri(MyAppUtil.DELETE_EMP_URL,1304)
		.retrieve()
		.bodyToMono(String.class);
		
		mono.subscribe(str -> System.out.println(str),
				ex-> {
					System.out.println("Employee Not Found ");
					
					
					if(ex instanceof WebClientResponseException)
					{
						WebClientResponseException wex = (WebClientResponseException) ex;
						System.out.println("Status Code : " + wex.getStatusCode());
			        	System.out.println("Message     : " + wex.getResponseBodyAsString());
					}
				});
*/
		
		// parial update, calling patch /update/{id}
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Don");
		map.put("salary", 60000.0);
		
		Mono<Employee> empMono = webClient.patch()
										.uri(MyAppUtil.PARTIAL_UPDATE, 1015)
										.bodyValue(map)
										.retrieve()
										.bodyToMono(Employee.class);
		
		empMono.subscribe(emp -> System.out.println(emp),
				ex-> {
					System.out.println("Employee Not Found ");
					
					
					if(ex instanceof WebClientResponseException)
					{
						WebClientResponseException wex = (WebClientResponseException) ex;
						System.out.println("Status Code : " + wex.getStatusCode());
			        	System.out.println("Message     : " + wex.getResponseBodyAsString());
					}
				});
		
	}
}
