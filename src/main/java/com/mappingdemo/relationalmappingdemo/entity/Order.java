package com.mappingdemo.relationalmappingdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_name")
	private String orderName;
	
	@Column(name="order_quantity")
	private int orderQuantity;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="zomato_customer_id")
	private ZomatoCustomer zomatoCustomer;

	public Order(String orderName, int orderQuantity,ZomatoCustomer customer) {
		super();
		this.orderName = orderName;
		this.orderQuantity = orderQuantity;
		this.zomatoCustomer=customer;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderQuantity=" + orderQuantity
				+ "]";
	}

	public ZomatoCustomer getZomatoCustomer() {
		return zomatoCustomer;
	}

	public void setZomatoCustomer(ZomatoCustomer zomatoCustomer) {
		this.zomatoCustomer = zomatoCustomer;
	}

	
	
	

}
