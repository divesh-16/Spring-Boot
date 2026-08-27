package com.tca.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminService 
{
	@Value("https://admin.tca.com")
	private String adminURL;
	
	@Value("7070")
	private int port;
	
	@Value("admin")
	private String userName;
	
	@Value("root@123")
	private String password;
	
	public void printInformation()
	{
		System.out.println("You are Connected to : "+adminURL);
		System.out.println("Port                 : "+port);
		System.out.println("Username             : "+userName);
		System.out.println("Password             : "+password);
	}
}
