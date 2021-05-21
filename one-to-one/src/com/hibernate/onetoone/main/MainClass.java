package com.hibernate.onetoone.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetoone.entity.Customer;
import com.hibernate.onetoone.entity.Customer_detail;

public class MainClass {
	
	public static void main(String []args) {
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Customer.class)
											.addAnnotatedClass(Customer_detail.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = new Customer("Ahmed","Camara");
		
		Customer_detail c_detail = new Customer_detail("abidjan,CIV","ahmed@gmail.com","SWE");
		
		customer.setC_detail(c_detail);
		
		try {
			
			session.beginTransaction();
			
			session.save(customer);
			
			session.getTransaction().commit();
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}
}
