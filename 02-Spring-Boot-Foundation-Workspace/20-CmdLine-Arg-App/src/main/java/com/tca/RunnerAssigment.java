package com.tca;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerAssigment implements ApplicationRunner
{

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		// TODO Auto-generated method stub
		@Nullable
		List<String> L = args.getOptionValues("theme-mode");
		if(L == null)
		{
			System.out.println("Light Mode Activated");
		}
		else if(L!= null && !L.isEmpty() && L.get(0).equals("dark") )
		{
			System.out.println("Dark Mode Activated");
		}
		else
		{
			System.out.println("Light Mode Activated");
		}
	}
	
}
