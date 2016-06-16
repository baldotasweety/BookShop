package com.niit.shoppingcart.test;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCat {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart.bean");
		context.refresh();
		
		
		
		try {
			context.getBean("category");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
