package com.spring.bookcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.bookcart.dao.*;
import com.spring.bookcart.model.User;
import com.spring.bookcart.model.User_Details;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	/*@RequestMapping("/isValid")
	public String showMessage(@RequestParam(value = "username")String username,
			@RequestParam(value = "password") String password, @ModelAttribute User user){
		
		
		System.out.println("in user controller");
		
	
	
		if(userDAO.isValid(username,password)){
			System.out.println("Valid Credentials");
			user = userDAO.getByName(username);
			System.out.println(user.isAdmin());
			if (user.isAdmin()==true){
		        return "adminHome";
		      }
			else{
		      return "Aboutus";
		    }
			
         }
		else
		{
			System.out.println("Invalid Credentials");
			 return "Theme";
		}
		
	        
	
	}*/
	
	 /* @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String doLogin(  @ModelAttribute User userr) {
		  System.out.println("admin"+userr.isAdmin());
	      if (userr.isAdmin()==true){
	        return "adminHome";
	      }
	      return "Aboutus";
	    }*/
		  
	        
	    

	@RequestMapping("/Login")
	public String getuser(){
		return "";
	}
	@RequestMapping("/adminHome")
	public String getAdmin()
	{
		return "adminHome";
	}
	@RequestMapping("/Landing")
	public String getHome()
	{
		System.out.println("user controller /theme");
		return "Landing";
	}
	@RequestMapping("/welcome")
	public String getguest()
	{
		return "Login";
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
	public String signUp(@ModelAttribute User_Details user_Details, @RequestParam("username") String username, @RequestParam("pass") String password, @RequestParam("email") String email, @RequestParam("city") String city )
	{
	    System.out.println("sdgjkd");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.spring.bookcart");
        context.refresh();
        
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("user details name="+user_Details.getEmail());
		User_Details user_details = (User_Details) context.getBean("user_Details"); 
		
		User user = (User) context.getBean("user");
		
		
		user.setUsername(username);
		user.setPassword(password);
	    user_details.setEmail(email);
		user_details.setCity(city);
		userDAO.saveOrUpdate(user);

		userDAO.saveOrUpdate(user_Details);

		return "Theme";
		

}
	
}