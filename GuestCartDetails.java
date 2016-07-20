package com.spring.bookcart.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//This will not be a Entity, its just an normal class we will use for Guests
//Once user login, all its content will be added to Entity CartDetails

@Component
public class GuestCartDetails {
	
	private String pId;
	private int cId;;
	private String sId;;
	private int qty;
	private int price;

	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
