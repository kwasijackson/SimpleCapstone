package com.charlesjackson.capstone.Entity;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
    
    @Entity
    public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderdetail_id;
	@DateTimeFormat(pattern = "YYYY-mm-dd") 
	private LocalDate orderplaced;
	private int quantity;
	private float price;
	@ManyToOne
	@JoinColumn(name ="pid")
	private Product product;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="orderid")
	private Orders orders;
	public OrderDetails(int orderdetail_id, LocalDate orderplaced, int quantity, float price, Product product,
			Orders orders) {
		super();
		this.orderdetail_id = orderdetail_id;
		this.orderplaced = orderplaced;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.orders = orders;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderdetail_id() {
		return orderdetail_id;
	}
	public void setOrderdetail_id(int orderdetail_id) {
		this.orderdetail_id = orderdetail_id;
	}
	public LocalDate getOrderplaced() {
		return orderplaced;
	}
	public void setOrderplaced(LocalDate orderplaced) {
		this.orderplaced = orderplaced;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderdetail_id=" + orderdetail_id + ", orderplaced=" + orderplaced + ", quantity="
				+ quantity + ", price=" + price + ", product=" + product + ", orders=" + orders + "]";
	}
	
	

}
