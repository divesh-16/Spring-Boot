package com.tca.service;

import java.util.List;

import com.tca.entity.CustomerLoan;

public interface CustomerLoanService 
{
	public CustomerLoan saveCustomerLoan(CustomerLoan customerLoan);
	public CustomerLoan fetchById(Long custId, Long loanId);
	public void removeById(Long custId, Long loanId);
	public List<CustomerLoan> fetchAll();
}
