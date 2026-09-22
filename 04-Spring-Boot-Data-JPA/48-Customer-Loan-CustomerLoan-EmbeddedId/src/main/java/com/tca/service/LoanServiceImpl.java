package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Loan;
import com.tca.repository.LoanRepository;

@Service("loanService")
public class LoanServiceImpl implements LoanService
{
	@Autowired
	private LoanRepository repo;

	@Override
	public Loan saveLoan(Loan l) 
	{
		return repo.save(l);
	}

	@Override
	public Loan fetchById(Long id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public void removeLoan(Long id) 
	{
		repo.deleteById(id);
	}

}
