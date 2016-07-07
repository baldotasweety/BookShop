package com.spring.bookcart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.bookcart.dao.CategoryDAO;
import com.spring.bookcart.model.Category;

@Controller
public class CategoryController {
	@Autowired(required=true)
	private CategoryDAO categoryDAO;
	
	
	public void setCategoryDAO(CategoryDAO ps){
		this.categoryDAO = ps;
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategorys(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "categoryList";
	}
	
	//For add and update category both
	@RequestMapping(value= "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category){
		
	
			categoryDAO.saveOrUpdate(category);
		
		return "redirect:/categories";
		
	}
	
	@RequestMapping("category/remove/{ct_id}")
    public String removeCategory(@PathVariable("ct_id") String id,ModelMap model) throws Exception{
		
       try {
		categoryDAO.delete(id);
		model.addAttribute("message","Successfully Removed");
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       //redirectAttrs.addFlashAttribute(arg0, arg1)
        return "categoryList";
    }
 
    @RequestMapping("category/edit/{ct_id}")
    public String editCategory(@PathVariable("ct_id") String id, Model model){
    	System.out.println("editCategory");
        model.addAttribute("category", this.categoryDAO.get(id));
        model.addAttribute("listCategorys", this.categoryDAO.list());
        return "categoryList";
    }
	}
