package com.tca.service;

import com.tca.entity.Loan;

public interface LoanService 
{
	public Loan saveLoan(Loan l);
	public Loan fetchById(Long id);
	
	public void removeLoan(Long id);
}
