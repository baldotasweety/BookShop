package com.spring.book.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.book.bean.*;

@Repository
public class SupplierDAO {
	
	public static List<Supplier> getAllSuppliers(){
		
		List<Supplier> list = new ArrayList<Supplier>();
		Supplier s1= new Supplier();
		s1.setId("SUP_BUK");
		s1.setName("Goel");
		s1.setAddress("Pune");
		list.add(s1);
		
		
		s1= new Supplier();
		s1.setId("SUP_Nov");
		s1.setName("Publishers House");
		s1.setAddress("Bangalore");
		list.add(s1);
		
		
		s1= new Supplier();
		s1.setId("SUP_gk");
		s1.setName("StarBooks");
		s1.setAddress("Hyderabad");
		list.add(s1);
		return list;
		
		
	}

}
