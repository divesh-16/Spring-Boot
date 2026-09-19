package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Passport;
import com.tca.repository.PassportRepository;

@Service("passportService")
public class PassportServiceImpl implements PassportService
{
	@Autowired
	PassportRepository repo;

	@Override
	public Passport savePassport(Passport passport) 
	{
		return repo.save(passport);
	}

	@Override
	public Passport fetchById(Long id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public void removeById(Long id) 
	{
		repo.deleteById(id);
	}
	
	

}
