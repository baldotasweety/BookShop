package com.spring.book.controller;
import com.spring.book.DAO.*;
import com.spring.book.bean.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	
	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories(){
		System.out.println("getAllCategories");
		List<Category> categoryList = categoryDAO.getAllCategories();
		
		ModelAndView mv = new ModelAndView("/categoryList");
		mv.addObject("categoryList",categoryList);
		return mv;
		
	}

}

