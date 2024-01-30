package com.charlesjackson.capstone.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@ManyToOne
	@JoinColumn(name ="pid")
	private Product product;
	@ManyToOne
	@JoinColumn(name ="emailid")
	private Login login;
	
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Cart(int cartId, Product product, Login login, int quantity) {
		super();
		
		this.product = product;
		this.login = login;
		this.quantity = quantity;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
