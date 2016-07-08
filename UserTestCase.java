package com.spring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bookcart.dao.UserDAO;
import com.spring.bookcart.model.User;

public class UserTestCase {
 
	
	UserDAO userDAO;
	User user;
	
	
	@Before
	public void init(){
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.spring.bookcart");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	@Test
	public void isValidTestCase(){
		
		assertEquals("Valid user", true, userDAO.isValid("sweety", "hello123"));
	}
	
	
	@Test
	public void getTest(){
		
		
		System.out.println(userDAO.get("AD101"));
		assertEquals("ID Confirmed","sweety", userDAO.get("AD101").getUsername());
	}

}
