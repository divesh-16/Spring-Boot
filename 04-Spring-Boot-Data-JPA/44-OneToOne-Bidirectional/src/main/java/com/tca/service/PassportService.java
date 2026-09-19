package com.tca.service;

import com.tca.entity.Passport;

public interface PassportService 
{
	public Passport savePassport(Passport passport);
	public Passport fetchById(Long id);
	public void removeById(Long id);
}
