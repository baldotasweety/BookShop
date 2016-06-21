package com.spring.book.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.book.bean.*;
import com.spring.book.DAO.*;

@Controller
public class SupplierController {
	

	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers() {
		System.out.println("getAllSuppliers");

		List<Supplier> supplierList = SupplierDAO.getAllSuppliers();

		ModelAndView mv = new ModelAndView("/supplierList");
		mv.addObject("supplierList", supplierList);

		return mv;

	}
}