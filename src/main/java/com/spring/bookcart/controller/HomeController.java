package com.spring.bookcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String show(){
		System.out.println("In controller");
		return "home";
	}
	
    
	
	
}
