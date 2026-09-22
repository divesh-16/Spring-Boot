package com.tca.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{

		// save customer
/*		
		Address a = new Address();
		a.setHouseNumber("333");
		a.setCity("Pune");
		a.setStreet("GaneshKhind");
		a.setPincode("411007");
		
		Customer c = new Customer();
		c.setCustomerId(103L);
		c.setName("CCC");
		c.setAddress(a);
		
		customerService.saveCustomer(c);
		System.out.println("Customer Saved");
*/
/*		
		// Loan 
		Loan loan = new Loan();	
		loan.setLoanId(9003L);
		loan.setLoanType(LoanType.HOME_LOAN);
		loan.setInterestRate(9.0);
		
		loanService.saveLoan(loan);
		System.out.println("Loan saved");
*/
/*
		// fetch customer and loan and then insert customerLoan
		Customer customer = customerService.fetchById(102L);
		Loan loan = loanService.fetchById(9001L);
		
		CustomerLoanId id = new CustomerLoanId(customer.getCustomerId(), loan.getLoanId());
		CustomerLoan custLoan = new CustomerLoan();
		custLoan.setId(id);
		custLoan.setCustomer(customer);
		custLoan.setLoan(loan);
		
		custLoan.setLoanAmount(400000L);
		custLoan.setPeriodOfMonths(12);
		
		customerLoanService.saveCustomerLoan(custLoan);
		System.out.println("Loan approved ");
*/
	
/*		
		// fetch customer and customer loan;
		
		Customer c = customerService.fetchById(101L);
		System.out.println("Customer ID      : "+c.getCustomerId());
		System.out.println("Customer NAME    : "+c.getName());
		System.out.println("Customer Address : "+c.getAddress());
		System.out.println("-".repeat(50));
		List<CustomerLoan> customerLoans = c.getCustomerLoans();
		for(CustomerLoan cl : customerLoans)
		{
			System.out.println("Loan ID       : "+cl.getId().getLoanId());
			System.out.println("Loan AMount   : "+cl.getLoanAmount());
			System.out.println("Loan Months   : "+cl.getPeriodOfMonths());
			System.out.println("Loan Interest : "+cl.getLoan().getInterestRate());
			System.out.println("Loan Type     : "+cl.getLoan().getLoanType());
			System.out.println("=".repeat(50));
		}
*/
/*	
		// fetch loan
		Loan l = loanService.fetchById(9001L);
		System.out.println("Loan ID       : "+l.getLoanId());
		System.out.println("Loan Interest : "+l.getInterestRate());
		System.out.println("Loan Type     : "+l.getLoanType());
		System.out.println("=".repeat(50));
		
		List<CustomerLoan> customerLoans = l.getCustomerLoans();
		for(CustomerLoan cl : customerLoans)
		{
			System.out.println("Customer ID      : "+cl.getCustomer().getCustomerId());
			System.out.println("Customer NAME    : "+cl.getCustomer().getName());
			System.out.println("Customer Address : "+cl.getCustomer().getAddress());
			System.out.println("Loan Amount      : "+cl.getLoanAmount());
			System.out.println("Loan Months      : "+cl.getPeriodOfMonths());
			System.out.println("=".repeat(50));
		}
	}
*/
/*		
		// fetchAll customerLoan
		List<CustomerLoan> list = customerLoanService.fetchAll();
		
		for(CustomerLoan cl : list)
		{
			System.out.println("Customer ID      : "+cl.getCustomer().getCustomerId());
			System.out.println("Customer NAME    : "+cl.getCustomer().getName());
			System.out.println("Customer Address : "+cl.getCustomer().getAddress());
			
			System.out.println("Loan ID       : "+cl.getId().getLoanId());
			System.out.println("Loan Interest : "+cl.getLoan().getInterestRate());
			System.out.println("Loan Type     : "+cl.getLoan().getLoanType());
			
			System.out.println("Loan Amount   : "+cl.getLoanAmount());
			System.out.println("Loan Months   : "+cl.getPeriodOfMonths());
			System.out.println("=".repeat(50));		
		
		}
*/
/*		
 		// delete customer with its loan entries in customerLoan
 		
		customerService.removeCustomer(101L);
		System.out.println("Customer Removed");
*/		
		customerLoanService.removeById(102L, 9001l);
		System.out.println("Customer Loan entry ");
		
		
	}

}
