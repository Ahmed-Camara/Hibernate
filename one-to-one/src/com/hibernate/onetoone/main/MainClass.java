package com.hibernate.onetoone.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.onetoone.entity.Customer;
import com.hibernate.onetoone.entity.Customer_detail;

/**
 * ONE TO ONE MAPPING
 * 		- unidirectional
 * 		- bidirectional
 * **/
public class MainClass {
	
	public static void main(String []args) {
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Customer.class)
											.addAnnotatedClass(Customer_detail.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			/**
			 * Uni-directional mapping
			 * **/
			// 1. Save customer
			Customer customer = new Customer("Ahmed","Camara");
			
			Customer_detail c_detail = new Customer_detail("abidjan,CIV","ahmed@gmail.com","SWE");
			
			customer.setC_detail(c_detail);
			
			session.beginTransaction();
			
			session.save(customer);
			
			session.getTransaction().commit();
		
			//2. Retrieve customer to database
			String id = "1";
			
			session.beginTransaction();
			
			Customer cust = session.get(Customer.class, id);
			
			System.out.println(cust);
			
			session.getTransaction().commit();
			
			//3. Delete customer from the database
			
			String customer_id = "1";
			
			session.beginTransaction();
			
			Customer cus = session.get(Customer.class, customer_id);
			
			if(cus == null) {
				System.out.println("Customer with id:"+customer_id+" does not exist.");
			}else {
				session.delete(cus);
			}
			
			session.getTransaction().commit();
			
			//4. Update customer information
			
			String cust_id = "2";
			
			session.beginTransaction();
			
			Query query = session.createQuery("update Customer c set c.first_name='idriss' where id=:id");
			query.setParameter("id", cust_id);
			int executed = query.executeUpdate();
			
			if(executed == 1) {
				System.out.println("Executed successfully");
			}else {
				System.out.println("Not Executed");
			}
			session.getTransaction().commit();
			
			
			
			
			
			System.out.println("****************************************************************************************************");
			
			
			
			/**
			 * bi-directional mapping
			 * 
			 * **/
			
			//1. save Customer using customer_detail
			Customer cs = new Customer("Idriss","Camara");
			
			Customer_detail c_details = new Customer_detail("abidjan,CIV","ahmed@gmail.com","SWE");
		
			c_details.setCustomer(cs);
			
			session.beginTransaction();
			session.save(c_details);
			session.getTransaction().commit();
			
			//2. Retrieve customer
			int c_id = 3;
			session.beginTransaction();
			Customer_detail customer_detail = session.get(Customer_detail.class, c_id);
			System.out.println("Customer Detail ==>> "+customer_detail);
			System.out.println("The associated Customer  ==>> "+customer_detail.getCustomer());
			session.getTransaction().commit();
			
			//3. Delete
			int customer_ids = 2;
			
			session.beginTransaction();
			
			Customer_detail customer_dt = session.get(Customer_detail.class, customer_ids);
			
			if(customer_dt == null) {
				System.out.println("Customer with id:"+customer_ids+" does not exist.");
			}else {
				session.delete(customer_dt);
				customer_dt.getCustomer().setC_detail(null);
			}
			
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			System.out.println("Error message : "+ex.getMessage());
		}
		
		
	}
}
