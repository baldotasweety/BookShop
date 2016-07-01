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
import org.springframework.web.servlet.ModelAndView;

import com.spring.bookcart.dao.SupplierDAO;
import com.spring.bookcart.model.Supplier;

@Controller
public class SupplierController {
	
	private SupplierDAO supplierDAO;
	
	@Autowired(required=true)
	@Qualifier(value="supplierDAO")
	public void setSupplierDAO(SupplierDAO ps){
		this.supplierDAO = ps;
	}
	
	@RequestMapping(value = "supplier", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "supplierList";
	}
	
	@RequestMapping(value="supplier/add", method = RequestMethod.POST)
 	
 	/*public ModelAndView addSupplier(@ModelAttribute Supplier supplier) {
		supplierDAO.saveOrUpdate(supplier);
	  return new ModelAndView("/AdminHome");
	 }*/

 	public String addSupplier(@ModelAttribute("supplier") Supplier supplier ,Model model){
 		model.addAttribute("supplier" , new Supplier());
 		model.addAttribute("supplierList", this.supplierDAO.list());
 		supplierDAO.saveOrUpdate(supplier);
 		return "supplierList";
 	}
 	
	@RequestMapping("supplier/remove/{sup_id}")
    public String removeSupplier(@PathVariable("sup_id") int id, ModelMap model) throws Exception{
		
       try {
		supplierDAO.delete(id);
		model.addAttribute("message","Successfully Removed");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
    
        return "supplierList";
    }
 	
 	
 	@RequestMapping(value="supplier/edit/{sup_id}" )
	 	
 	public String editSupplier(@PathVariable("sup_id") int id, Supplier supplier , Model model){
 		System.out.println("editsupplier");
 		model.addAttribute("supplier" ,new Supplier());
 		model.addAttribute("supplier", this.supplierDAO.get(id));
 		model.addAttribute("supplierList", this.supplierDAO.list());
 		return "supplierList";
 	}	 	
}
