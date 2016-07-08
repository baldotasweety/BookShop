package com.spring.bookcart.dao;

import java.util.List;

import com.spring.bookcart.model.Category;
import com.spring.bookcart.model.User;

public interface UserDAO {

	

	public List<User> list();
	public void saveOrUpdate(User user);
	public void delete(String id);
	public User get(String id);
	public boolean isValid(String username, String password);
	


}
