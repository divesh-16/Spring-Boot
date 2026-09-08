package com.tca.generators;

import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator
{
	String prefix;
	
	public IdGenerator(MyTcaId ob)
	{
		this.prefix = ob.name();
	}
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) 
	{
		
		Random r = new Random();
		int a = r.nextInt(9);
		int b = r.nextInt(9);
		int c = r.nextInt(9);
		int d = r.nextInt(9);
		
		return "TCA-"+prefix+"-"+a+b+c+d;
	}
}
