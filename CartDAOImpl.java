package com.spring.bookcart.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bookcart.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl {

	

		@Autowired
		private SessionFactory sessionFactory;
		
		public CartDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		 @Transactional
		public List<Cart> getCart(String uId) {
			String hql = "from Cart where uId="+uId;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Cart> cartList = query.list();
			if(cartList!=null && !cartList.isEmpty())
				return cartList;
			return null;
		}

		@Transactional
		public void update(String uId, String pId, int cId, String sId, int qty) {
			String hql = "update Cart set qty="+qty+" where pId="+pId+" and cId="+cId+" and sId="+sId+" and uId='"+uId+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
		}

		@Transactional
		public void save(Cart cart){
			sessionFactory.getCurrentSession().save(cart); 
		}
		
		@Transactional
		public void delete(String uId, String pId, int cId, String sId) {
			String hql = "delete from Cart where pId="+pId+" and cId="+cId+" and sId="+sId+" and uId='"+uId+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			int result = query.executeUpdate();
		}
		
		
	}

