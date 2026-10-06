package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController 
{
	@GetMapping(value ="/msg")
	public String getMessage(@RequestParam String un, Model model)
	{
		model.addAttribute("username", un);
		return "Hello";
	}
}
