package com.tca.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunnerApp implements ApplicationRunner 
{
	@Autowired
	JdbcTemplate jt;

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		String INSERT_USER_SQL="INSERT INTO users(username,password,enabled) VALUES(?,?,?)";
		String INSERT_ROLE_SQL="INSERT INTO AUTHORITIES(username, authority) VALUES(?,?)";
		
		jt.update(INSERT_USER_SQL, "divesh",bcrypt.encode("div@123"),true);
		jt.update(INSERT_USER_SQL, "rohit",bcrypt.encode("roh@123"),true);
		jt.update(INSERT_USER_SQL, "vinod",bcrypt.encode("vin@123"),false);
		
		jt.update(INSERT_ROLE_SQL,"divesh","ROLE_ADMIN");
		jt.update(INSERT_ROLE_SQL,"rohit","ROLE_MANAGER");
		jt.update(INSERT_ROLE_SQL,"vinod","ROLE_MANAGER");
		
		System.out.println("Users Data with Roles Created.....");
	}

}
