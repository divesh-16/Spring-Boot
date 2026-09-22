package com.tca.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;
import com.tca.service.CustomerLoanService;

@Component
public class MyRunner implements ApplicationRunner 
{
	@Autowired
	CustomerLoanService service;

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*		
		CustomerLoanId ob = new CustomerLoanId(101L,9001L);
		
		CustomerLoan custLoan = new CustomerLoan();
		custLoan.setId(ob);
		custLoan.setLoanAmount(500000L);
		custLoan.setPeriodOfMonths(24);
		
		custLoan = service.saveCustomerLoan(custLoan);
		System.out.println("Customer Loan sanctioned"+custLoan);
*/
/*		
		CustomerLoan custLoan = service.fetchById(101L, 9001L);
		System.out.println(custLoan);
*/		
		service.removeById(101L, 9001L);
	}

}
