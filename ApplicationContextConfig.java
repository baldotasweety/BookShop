package com.spring.bookcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.bookcart.dao.CartDAO;
import com.spring.bookcart.dao.CartDAOImpl;
import com.spring.bookcart.dao.CategoryDAO;
import com.spring.bookcart.dao.CategoryDAOImpl;
import com.spring.bookcart.model.Cart;
import com.spring.bookcart.model.Category;
import com.spring.bookcart.model.Product;
import com.spring.bookcart.model.Supplier;
import com.spring.bookcart.model.User;
import com.spring.bookcart.model.User_Details;




@Configuration
@ComponentScan("com.spring.bookcart")
@EnableTransactionManagement
public class ApplicationContextConfig {
	

    
	 @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    	dataSource.setUsername("sa");
	    	dataSource.setPassword(""); 
	    	
	    	return dataSource;
	    }
	    
	    
	    private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	properties. put("hibernate.hbm2ddl.auto","update");
	    	return properties;
	    } 
     
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(Supplier.class);
    	sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(Product.class);
    	sessionBuilder.addAnnotatedClasses(User_Details.class);
    	sessionBuilder.addAnnotatedClasses(Cart.class);
    	
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
    @Autowired
    @Bean(name = "categoryDAO")
    public CategoryDAO geCategorDao(SessionFactory sessionFactory) {
    	return new CategoryDAOImpl(sessionFactory);
    }


    @Autowired
    @Bean(name = "cartDAO")
    public CartDAOImpl geCartDao(SessionFactory sessionFactory) {
    	return new CartDAOImpl(sessionFactory);
    }
}