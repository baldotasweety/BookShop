package com.spring.bookcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.bookcart.dao.*;
import com.spring.bookcart.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/isValid")
	public ModelAndView showMessage(@RequestParam(value = "username")String username,
			@RequestParam(value = "password") String password){
		
		ModelAndView mv;
		System.out.println("in user controller");
		
		String message;
	
		if(userDAO.isValid(username,password)){
			message = "Valid Credentials";
			mv = new ModelAndView("adminHome");
			mv.addObject("message",message);
			
			
		}
		else
		{
			message = "Invalid Credentials";
			 mv = new ModelAndView("Theme");
			 mv.addObject("message",message);
		}
	
	
	//mv = new ModelAndView("success");
	mv.addObject("message",message);
	mv.addObject("name",username);
	
	return mv;
	
	}
	
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String doLogin(@Valid User user, BindingResult result) {
		  if (result.hasErrors()) {
	            return "Login";
	        }
	 
	        return "adminHome";
	    }
		  
	        
	    

	/*@RequestMapping("/Login")
	public String getLogin()
	{
		return "Theme";
	}*/
	/*@RequestMapping("/welcome")
	public String basic(){
		return "welcome";
	}*/
	/*@RequestMapping("/")
	public String getLanding()
	{
		System.out.println("theme page called..");
		return "Theme";
	}*/
	@RequestMapping("/Success")
	public String getuser(){
		return "Success";
	}
	@RequestMapping("/adminHome")
	public String getAdmin()
	{
		return "adminHome";
	}
	@RequestMapping("/Theme")
	public String getHome()
	{
		return "Theme";
	}
	@RequestMapping("/welcome")
	public String getguest()
	{
		return "welcome";
	}
	/*@RequestMapping("/contact")
	public String getContact()
	{
		return "";
	}
	@RequestMapping("/aboutus")
	public String geAboutUs()
	{
		return "aboutus";
	}
	@RequestMapping("/signup")
	public String getSignup()
	{
		return "signup";
	}
	*/
	@RequestMapping("/OK")
	public String signUp()
	{
	
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		User user = (User) context.getBean("user"); 
		user.setName("username");
	    user.setEmail("email");
		user.setCity("city");
		
		userDAO.saveOrUpdate(user);

		return "Theme";
		

}
	
}