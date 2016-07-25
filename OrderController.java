package com.spring.bookcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import com.spring.bookcart.dao.*;
import com.spring.bookcart.model.User;

@Component
public class OrderController {

	@Autowired
	UserDAO userDao;
	
	public User initFlow(){
		System.out.println("inside order controller initFlow()");
		User u = new User();
		u.setId("2");
		u.setUsername("suchi");
		u.setCity("Pune");;
		u.setEmail("suchi@gmail.com");
		u.setContactNum(123211);
		
		/*Address a1 = new Address();
		a1.setStreet("road 8");
		a1.setCity("pune");
		a1.setState("MH");
		a1.setPincode(411044);
		List<Address> addrList = new ArrayList<Address>();
		addrList.add(a1);
		
		Address a2 = new Address();
		a2.setStreet("road 10");
		a2.setCity("pune");
		a2.setState("MH");
		a2.setPincode(411040);
		addrList.add(a2);
		
		u.setAddressList(addrList);
		*/
		return u;
		
	}
	
	/*@RequestMapping("/confirmOrderContacts")
	public String confirmContact(HttpSession session, Model model){
		System.out.println("inside Order controller");
		model.addAttribute("user",session.getAttribute("loggedUser"));
		return "confirmOrderContacts";
	}*/
}
