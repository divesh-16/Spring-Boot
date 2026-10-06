package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class MessageController 
{
	@GetMapping(value ="/msg")
	public String getMessage()
	{
		return "Hello";
	}
}
