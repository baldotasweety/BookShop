package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	@RequestMapping("/home")
	public String show(){
		System.out.println("In controller");
		return "home";
	}
	
	@RequestMapping("/Login")
	public String disp(){
		return "Login";
	}
	
	
	@RequestMapping("/SignUp")
	public String display(){
		return "SignUp";
	}

}
