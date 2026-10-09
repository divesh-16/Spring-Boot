package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController 
{
	// call on browser = http://localhost:8081/msg?un=divesh
	@GetMapping("/msg")
	public String getMessage(@RequestParam("un")String un, Model model)
	{
		model.addAttribute("msg", un);
		
		return "hello";
	}

}
