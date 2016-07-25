package com.spring.bookcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.spring.bookcart.dao.*;
import com.spring.bookcart.model.Cart;
import com.spring.bookcart.model.User;
import com.spring.bookcart.model.User_Details;


/* In this controller mappings are given for sign up login or user based activities 
 as far as user is concerned*/
@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	
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
		  
	        
	    
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
	    /*HttpSession session = request.getSession(false);
	    session.invalidate();*/
	    return "Landing";
	}
	@RequestMapping("/adminHome")
	public String getAdmin()
	{
		return "adminHome";
	}
	@RequestMapping("/Landing")
	public String getHome()
	{
		System.out.println("user controller");
		return "Landing";
	}
	
	@Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {

        RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
        rmha.setCacheSeconds(0);

        return rmha;
    }
	@RequestMapping("/welcome")
	public String getguest()
	{
		return "Landing";
	}
	
	/*@RequestMapping("/displayCart")
	public String getCart()
	{
		return "displayCart";
	}*/
	/*@RequestMapping("/ProDemo")
	public String getPro()
	{
		return "ProDemo";
	}*/
	@RequestMapping("/Aboutus")
	public String geAboutUs()
	{
		System.out.println("in cart");
		
		return "Aboutus";
	}
	@RequestMapping("/SignUp")
	public String getSignup()
	{
		return "SignUp";
	}
	
	
	@RequestMapping("/OK")
	public String signUp(@Valid @RequestParam("username") String username, @RequestParam("pass") String password, @RequestParam("email") String email, @RequestParam("city") String city )
	{
	    System.out.println("sdgjkd");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.spring.bookcart");
        context.refresh();
        
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("user details name="+user.getEmail());
		//User_Details user_details = (User_Details) context.getBean("user_Details"); 
		
		User user = (User) context.getBean("user");
		
		
		user.setUsername(username);
		user.setPassword(password);
	    user.setEmail(email);
		user.setCity(city);
		userDAO.saveOrUpdate(user);

		/*userDAO.saveOrUpdate(user_Details);*/

		return "Landing";
		

}
	
	@RequestMapping(method=RequestMethod.GET, value="/userHasLogged")
	public String userHasLogged(HttpSession session,Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		/*User user1 = (User) context.getBean("user");
		if (user1 != null) {*/
				user = userDAO.getByName(name);
				System.out.println("user is now instantiated: "+user.getUsername());
		/*}*/
		
		
		if(session.getAttribute("loggedUsername") == null || session.getAttribute("loggedUsername") == ""){
			session.setAttribute("loggedUserRole", "ROLE_USER");
			session.setAttribute("loggedUsername",name);
			session.setAttribute("loggedUser", user);
			System.out.println("userHasLogged!!!!!!!!!");
			System.out.println("session loggedUsername set to="+name+" logged user="+user);
		}
		
	
		return "ProDemo";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/adminHasLogged")
	public String adminHasLogged(HttpSession session,Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.spring.bookcart");
        context.refresh();
        
		user = (User)context.getBean("user");
		if (user != null) {
			if(user.getId() == ""){
				user = userDAO.getByName(name);
		}
		
		
		if(session.getAttribute("loggedUsername") == null || session.getAttribute("loggedUsername") == ""){
			session.setAttribute("loggedUserRole", "ROLE_USER");
			session.setAttribute("loggedUserName", name);
			session.setAttribute("loggedUser", user);
			System.out.println("userHasLogged!!!!!!!!!");
			System.out.println("session loggedUserName set to="+name+" logged user="+((User) session.getAttribute("loggedUser")).getId());
		}
		}
		return "adminHome";
	}
	
}