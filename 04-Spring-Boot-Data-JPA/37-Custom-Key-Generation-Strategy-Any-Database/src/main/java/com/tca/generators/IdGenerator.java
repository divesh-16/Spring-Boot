package com.tca.generators;

import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator
{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) 
	{
		String s = "TCA";
		Random r = new Random();
		int a = r.nextInt(9);
		int b = r.nextInt(9);
		int c = r.nextInt(9);
		int d = r.nextInt(9);
		
		return s+"-"+a+b+c+d;
	}
}
