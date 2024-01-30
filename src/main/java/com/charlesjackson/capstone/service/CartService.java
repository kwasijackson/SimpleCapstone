package com.charlesjackson.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charlesjackson.capstone.Entity.Cart;
import com.charlesjackson.capstone.Entity.Login;
import com.charlesjackson.capstone.Entity.Product;
import com.charlesjackson.capstone.repository.CartRepository;
import com.charlesjackson.capstone.repository.LoginRepository;
import com.charlesjackson.capstone.repository.ProductRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	CartRepository cartRepository1;
	

	public ResponseEntity<String> addToCart(Cart cart){

		 
			 cartRepository.save(cart);
			 return new ResponseEntity<> ("Added to Cart Successfully",HttpStatus.CREATED);
						}
		   

	public List<Cart> findAllCartByUser(String emailid) {
		Login login = loginRepository.findById(emailid).orElse(null);
		if(login!= null) {
			return cartRepository.findByLogin(login);
		}
		return null;	
			
	}


	public String deleteCartById(Integer id) {
		cartRepository.deleteById(id);
		return "Record deleted Successfully";
	}
}
