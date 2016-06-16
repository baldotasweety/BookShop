package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/isValid")
	public ModelAndView showMessage(@RequestParam(value = "name")String name,
			@RequestParam(value = "password") String password){
		System.out.println("in controller");
		
		String message;
		if(userDAO.isValid(name,password)){
			message = "Valid Credentials";
		}
		else
		{
			message = "Invalid Credentials";
		}
	}
	
	ModelAndView mv = new ModelAndView("success");
	mv.addObject("message",message);
	mv.addObject("name",name);
	
	return mv;
	
	}
