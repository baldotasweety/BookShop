package com.spring.bookcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bookcart.dao.*;
import com.spring.bookcart.model.Cart;
import com.spring.bookcart.model.Category;
import com.spring.bookcart.model.GuestCartDetails;
import com.spring.bookcart.model.Product;
import com.spring.bookcart.model.Supplier;
import com.spring.bookcart.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class cartController implements ApplicationContextAware{
	
	@Autowired(required=true)
	private ProductDAO productDAO;
	@Autowired
	private User user;
	@Autowired
	private Cart cartItem;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private Supplier supplier;
	
	
	@Autowired
	private Category category;
	@Autowired
	private Product product;
	/*
	private List<GuestCartDetails> guestCart = null;*/
	ApplicationContext context;
	
	/*public List<GuestCartDetails> getGuestCart() {
		return guestCart;
	}

	public void setGuestCart(List<GuestCartDetails> guestCart) {
		this.guestCart = guestCart;
	}*/

	@RequestMapping(method=RequestMethod.GET,value="/user/addToCart/{pId}/{cId}")
	public String addtoCartUser(HttpSession session, @PathVariable("pId") String pId, @PathVariable("cId") int cId){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("auth: "+auth);
		GuestCartDetails guestCart = (GuestCartDetails) context.getBean("guestCartDetails");
		guestCart.setPrice(1111);
		if (session.getAttribute("loggedUserName") == null || session.getAttribute("loggedUserName") == "") {
			guestCart = (GuestCartDetails) context.getBean("guestCartDetails");
			Product p = productDAO.getProduct(pId);
			guestCart.setpId(pId);
			guestCart.setcId(p.getCategory().getCt_id());
			guestCart.setsId(p.getSupplier().getSup_id());
			guestCart.setPrice(p.getPrice());
			guestCart.setQty(1);
		}else{
			user = (User) session.getAttribute("loggedUser");
			cartItem.setUser_FK(user);
			
			product = productDAO.getProduct("pId");
			cartItem.setProduct_FK(product);
			cartItem.setCategory_FK(product.getCategory());
			cartItem.setSupplier_FK(product.getSupplier());
			cartItem.setPrice(product.getPrice());
			cartItem.setQty(1);
			
			List<Cart> cart = cartDAO.getCart(user.getId());
			if(cart == null){
				cart = new ArrayList<Cart>();
			}
			cart.add(cartItem);
			cartDAO.save(cartItem);
			//userDao.saveOrUpdate(user);
			System.out.println("saved into cart!");
		}
		
		switch (cId) {
		case 1:
			return "redirect: user/product/1";
		
		case 2: 
			return "redirect: user/product/2";
			
		default:
			return "redirect: user/product/1";
		}
		
	}

	@RequestMapping(method=RequestMethod.GET,value="/addToCart/{pId}")
	public void addtoCart(@PathVariable("pId") int pId){
		GuestCartDetails guestCart = (GuestCartDetails) context.getBean("guestCartDetails");
		System.out.println("GusetCartDetails Price: "+guestCart.getPrice());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("auth: "+auth.getPrincipal().toString());
	}
	
	@RequestMapping("displayCart")
	public String displayCart(HttpSession session){
		ModelAndView model = new ModelAndView("displayCart");
		user = (User) session.getAttribute("loggedUser");
		List<Cart> cartList = cartDAO.getCart(user.getId());
		java.util.Iterator<Cart> i = cartList.iterator();
		while(i.hasNext()){
			Cart cd = i.next();
			System.out.println("suppl" + cd.getSupplier_FK().getSup_id());
		}
		model.addObject("cartList",cartList);
		return "displayCart";
	}
	
	@RequestMapping("deleteFromCart/{pId}/{cId}/{sId}")
	public String deleteFromCart(HttpSession session, @PathVariable("pId") String pId, @PathVariable("cId") int cId,@PathVariable("sId") int sId){
		user = (User) session.getAttribute("loggedUser");
		cartDAO.delete(user.getId(), product.getId(), category.getCt_id(), supplier.getSup_id());
		return "redirect:/displayCart";
	}
	
	@RequestMapping("updateCartItemQty")
	public String updateCartItem(HttpSession session, @RequestParam("updateProductId") int pId, @RequestParam("updateSupplierId") int sId, @RequestParam("qty") int qty){
		user = (User) session.getAttribute("loggedUser");
		Product p = productDAO.getProduct("pId");
		cartDAO.update(user.getId(), p.getId(), p.getCategory().getCt_id(), p.getSupplier().getSup_id(), qty);
		return "redirect: /displayCart";
	}
	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("Cart Controller context: "+context);
		
	}

}
