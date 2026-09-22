package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.CustomerLoan;
import com.tca.entity.CustomerLoanId;
import com.tca.repository.CustomerLoanRepository;

@Service("customerLoan")
public class CustomerLoanServiceImpl implements CustomerLoanService 
{
	@Autowired
	CustomerLoanRepository repo;

	@Override
	public CustomerLoan saveCustomerLoan(CustomerLoan customerLoan) 
	{
		return repo.save(customerLoan);
	}

	@Override
	public CustomerLoan fetchById(Long custId, Long loanId) 
	{
		CustomerLoanId ob = new CustomerLoanId(custId, loanId);
		return repo.findById(ob).get();
	}

	@Override
	public void removeById(Long custId, Long loanId) 
	{
		CustomerLoanId ob = new CustomerLoanId(custId, loanId);
		repo.deleteById(ob);
	}

}
