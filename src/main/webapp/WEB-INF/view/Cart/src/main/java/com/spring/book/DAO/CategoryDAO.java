package com.spring.book.DAO;


import com.spring.book.bean.*;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CategoryDAO{
	
	
	public  List<Category> getAllCategories(){
		
		
		List<Category> list= new ArrayList<Category>();
		Category c1 = new Category();
		c1.setId("cat_nov");
		c1.setName("Novels");
		c1.setDescription("All types of novels");
		
		list.add(c1);
		
		c1 = new Category();
		c1.setId("cat_gk");
		c1.setName("General Knowledge");
		c1.setDescription("All types of gk books");
		
		list.add(c1);
		
		
		c1 = new Category();
		c1.setId("cat_dic");
		c1.setName("Dictionaries");
		c1.setDescription("All types of dictionaries");
		
		list.add(c1);
		
		return list;
	}
}