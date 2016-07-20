package com.spring.bookcart.dao;

import java.util.List;

import com.spring.bookcart.model.Cart;

public interface CartDAO {

	
public List<Cart> getCart(String uId);
	
	public void update(String uId, String pId, int cId, String sId, int qty);
	
	public void save(Cart cart);
	
	public void delete(String uId, String pId, int cId, String sId);
}

