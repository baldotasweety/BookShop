package com.spring.bookcart.controller;
import com.spring.bookcart.dao.*;
import com.spring.bookcart.model.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	

	/*@RequestMapping("category/add")
	public ModelAndView addCategory(@ModelAttribute Category category) {
		categoryDAO.saveOrUpdate(category);
	  return new ModelAndView("categoryList");
	 }*/


	@RequestMapping(value = "categories", method = RequestMethod.GET)
	 public String listCategories(Model model){
		 model.addAttribute("category", new Category());
		 List sList = this.categoryDAO.list();
		 model.addAttribute("categoryList",sList);
		 //System.out.println("in controller" +sList);
		 return "categoryList";
	 }
	@RequestMapping(value="/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model){
 		model.addAttribute("category" , new Category());
 		model.addAttribute("categoryList" , this.categoryDAO.list());
 		
 		categoryDAO.saveOrUpdate(category);
 		return "categoryList";
 	}
	@RequestMapping("category/remove/{ct_id}")
    public String removeCategory(@PathVariable("ct_id") int id,ModelMap model) throws Exception{
		
       try {
		categoryDAO.delete(id);
		model.addAttribute("message","Successfully Added");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       
        return "categoryList";
    }
 	@RequestMapping(value = "category/edit/{ct_id}")
 	
 	public String editCategory(@PathVariable("ct_id") int id, Model model, Category category){
 		System.out.println("editcategory");
 		model.addAttribute("category" , new Category());
 		model.addAttribute("category", this.categoryDAO.get(id));
 		model.addAttribute("categoryList", this.categoryDAO.list());
 		return "categoryList";
 	}	 	

}