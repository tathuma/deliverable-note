package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.SampleValue;

@Controller
public class SampleController {
	
	@GetMapping("/index")
	public String showList(Authentication loginUser, Model model) {
		
		model.addAttribute("userName", loginUser.getName());
		model.addAttribute("role", loginUser.getAuthorities());
		model.addAttribute("samplevalue", "Hello World");
		return "index";
	}
	
	@PostMapping("/test")
	public String testPost(@Validated 
			@ModelAttribute("samplevalue") SampleValue samplevalue,
			BindingResult result) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	

}
