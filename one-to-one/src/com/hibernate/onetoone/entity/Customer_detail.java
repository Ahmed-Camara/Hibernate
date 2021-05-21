package com.hibernate.onetoone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_detail")
public class Customer_detail {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="profession")
	private String profession;
	
	public Customer_detail() {}

	public Customer_detail(String address, String email, String profession) {
		super();
		this.address = address;
		this.email = email;
		this.profession = profession;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Customer_detail [id=" + id + ", address=" + address + ", email=" + email + ", profession=" + profession
				+ "]";
	}
	
	
}
