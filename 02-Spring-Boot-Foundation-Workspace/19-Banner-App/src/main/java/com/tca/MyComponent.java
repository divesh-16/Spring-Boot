package com.tca;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent 
{
	@Value("${spring.application.name}")
	String appName;
	
	public String getAppName()
	{
		return appName;
	}
	
}
