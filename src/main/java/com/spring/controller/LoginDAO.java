package com.spring.controller;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	
	public boolean isValid(String username, String password)
	{
		if(username.equals("sweety")&& password.equals("hello123"))
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}

}
