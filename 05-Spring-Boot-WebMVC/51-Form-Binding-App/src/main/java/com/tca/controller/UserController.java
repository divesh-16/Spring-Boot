package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tca.model.User;

@Controller
public class UserController 
{
	@GetMapping("/form")
	public String showForm(Model model)
	{
		User u = new User();
		model.addAttribute("user", u);
		
		return "User";
	}
	
	@PostMapping("/register")
	public String handleForm(@ModelAttribute User user, Model model)
	{
		model.addAttribute("a", user.getUsername());
		model.addAttribute("b", user.getEmail());
		model.addAttribute("c", user.getMobile());
		model.addAttribute("d", user.getGender());
		
		return "UserDetails";
		
	}
}
