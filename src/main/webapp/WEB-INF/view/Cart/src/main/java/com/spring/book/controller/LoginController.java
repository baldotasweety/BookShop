package com.spring.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.book.DAO.*;

@Controller
public class LoginController {
	
	@RequestMapping("/Login")
	String showLoginController(){
		System.out.println("in Login");
		return "Login";
	}
	
	
	@RequestMapping("/SignUp")
	String showsSignup(){
		System.out.println("Signing up");
		return "SignUp";
	}
	@Autowired
	LoginDAO loginDAO;
	
	@RequestMapping("/isValid")
	public ModelAndView showMessage(@RequestParam(value = "name")String name,
			@RequestParam(value = "password") String password){
		
		ModelAndView mv;
		System.out.println("in controller");
		
		String message;
	
		if(loginDAO.isValid(name,password)){
			message = "Valid Credentials";
			mv = new ModelAndView("adminHome");
			mv.addObject("message",message);
			
			
		}
		else
		{
			message = "Invalid Credentials";
			 mv = new ModelAndView("Login");
			 mv.addObject("message",message);
		}
	
	
	//mv = new ModelAndView("success");
	mv.addObject("message",message);
	mv.addObject("name",name);
	
	return mv;
	
	}
}