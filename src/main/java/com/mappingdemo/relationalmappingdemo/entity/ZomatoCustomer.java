package com.mappingdemo.relationalmappingdemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "zomatoCustomer",cascade = CascadeType.ALL)
	private List<Order> orders;

	
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


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "ZomatoCustomer [customerId=" + customerId + ", name=" + name + ", city=" + city + ", orders=" + orders
				+ "]";
	}

	public void addOrder(Order order) {
		if(orders==null) {
			orders=new ArrayList<>();
		}
		
		order.setZomatoCustomer(this);
		orders.add(order);
		
		
	}

	

}
