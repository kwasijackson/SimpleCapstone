package com.charlesjackson.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesjackson.capstone.Entity.Cart;
import com.charlesjackson.capstone.Entity.Login;
import com.charlesjackson.capstone.service.CartService;
import com.charlesjackson.capstone.service.LoginService;

@RestController
@RequestMapping("cart")
@CrossOrigin
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired LoginService loginService;
	
	@PostMapping(value = "addToCart")
	public ResponseEntity<String> toCart(@RequestBody Cart cart) {
		
		return cartService.addToCart(cart);
		
	}
	
	
	@GetMapping(value = "myCart/{emailid}")
	public  List<Cart> myCart(@PathVariable String emailid) {
						
		return cartService.findAllCartByUser(emailid);
    }
	
	@DeleteMapping("delete/{Id}")
	   public String deleteCategoryById(@PathVariable Integer Id) {
		   return cartService.deleteCartById(Id);
	   }

}
