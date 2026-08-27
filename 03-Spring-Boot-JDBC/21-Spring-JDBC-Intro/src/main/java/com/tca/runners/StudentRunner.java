package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentRunner implements ApplicationRunner 
{
	@Autowired
	JdbcTemplate jt;

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		// Drop table
		jt.execute("DROP TABLE IF EXISTS student");
		System.out.println("Table Dropped");
		
		// Create Table
		jt.execute("create table student(rno int primary key, name varchar(20), per float, city varchar(20))");
		System.out.println("Table Created ");
		
		
	}

}
