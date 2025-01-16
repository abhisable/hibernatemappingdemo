package com.mappingdemo.relationalmappingdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "zomato_customer")
public class ZomatoCustomer {

	@Column(name = "customer_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	private String name;
	
	private String city;

	
	public ZomatoCustomer(String name,String city) {
		super();
		this.name = name;
		this.city=city;
		
	}

	public ZomatoCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ZomatoCustomer [customerId=" + customerId + ", name=" + name +", city="+city+ "]";
	}

	

}
