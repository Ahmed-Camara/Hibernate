package com.hibernate.onetoone.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionTest {

	public static void main(String[] args) {
		
		String dbURL = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
		String user = "camara";
		String password ="ahmed";
		
		try {
			System.out.println("Database connection...!!!!");
			Connection connection =
					DriverManager.getConnection(dbURL,user,password);
			
			System.out.println("Done...!!!");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
