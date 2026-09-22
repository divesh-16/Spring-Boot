package com.tca.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Customer;
import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;
import com.tca.entity.Loan;
import com.tca.service.CustomerLoanService;
import com.tca.service.CustomerService;
import com.tca.service.LoanService;

@Component
public class MyRunner implements ApplicationRunner 
{
	@Autowired
	private CustomerLoanService customerLoanService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoanService loanService;

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
/*
		// save customer
		Address a = new Address();
		a.setHouseNumber("111");
		a.setCity("Pune");
		a.setStreet("GaneshKhind");
		a.setPincode("411007");
		
		Customer c = new Customer();
		c.setCustomerId(101L);
		c.setName("AAA");
		c.setAddress(a);
		
		customerService.saveCustomer(c);
		System.out.println("Customer Saved");
*/
/*		
		// Loan 
		Loan loan = new Loan();	
		loan.setLoanId(9001L);
		loan.setLoanType(LoanType.EDUCATION_LOAN);
		loan.setInterestRate(14.0);
		
		loanService.saveLoan(loan);
		System.out.println("Loan saved");
*/
		
		// fetch customer and loan and then insert customerLoan
		Customer customer = customerService.fetchById(101L);
		Loan loan = loanService.fetchById(9001L);
		
		CustomerLoanId id = new CustomerLoanId(customer.getCustomerId(), loan.getLoanId());
		CustomerLoan custLoan = new CustomerLoan();
		custLoan.setId(id);
		custLoan.setCustomer(customer);
		custLoan.setLoan(loan);
		
		custLoan.setLoanAmount(500000L);
		custLoan.setPeriodOfMonths(24);
		
		customerLoanService.saveCustomerLoan(custLoan);
		System.out.println("Loan approved ");

		
		// fetch customer and customer loan;
		
		
	}

}
